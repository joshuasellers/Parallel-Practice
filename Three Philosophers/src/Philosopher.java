import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable{
    private int id;
    private Chopstick left;
    private Chopstick right;

    public Philosopher(int id, Chopstick l, Chopstick r){
        this.id = id;
        this.left = l;
        this.right = r;
    }

    public void run(){
        System.out.printf("Philosopher %d is hungry\n", this.id);
        try {
            /*
            // Original way - creates deadlock
            while (!this.left.pickUp(this.id)) {
                int r = ThreadLocalRandom.current().nextInt(0,500);
                System.out.printf("Philosopher %d is waiting for left\n", this.id);
                Thread.sleep(r);
            }
            while (!this.right.pickUp(this.id)) {
                int r = ThreadLocalRandom.current().nextInt(0,500);
                System.out.printf("Philosopher %d is waiting for right\n", this.id);
                Thread.sleep(r);
            }
            */
            // New way - fixes deadlock
            while (this.left.getHeld() || this.right.getHeld()) {
                int r = ThreadLocalRandom.current().nextInt(0,500);
                System.out.printf("Philosopher %d is waiting for chopsticks\n", this.id);
                Thread.sleep(r);
            }
            this.left.pickUp(this.id);
            this.right.pickUp(this.id);
            System.out.printf("Philosopher %d is eating\n", this.id);
            Thread.sleep(500);
            System.out.printf("Philosopher %d is done eating\n", this.id);
            this.right.putDown(this.id);
            this.left.putDown(this.id);
        }
        catch (InterruptedException e){
            System.out.println("Interrupted");
        }

    }
}
