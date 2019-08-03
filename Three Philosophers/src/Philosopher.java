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
        System.out.printf("Philosopher %d is hungry", this.id);

    }
}
