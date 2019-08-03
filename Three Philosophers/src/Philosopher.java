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
            while (!this.left.pickUp(this.id)) {
                System.out.printf("Philosopher %d is waiting for left\n", this.id);
                Thread.sleep(100);
            }
            while (!this.right.pickUp(this.id)) {
                System.out.printf("Philosopher %d is waiting for right\n", this.id);
                Thread.sleep(100);
            }
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
