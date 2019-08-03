public class Philosopher {
    private int id;
    private Chopstick left;
    private Chopstick right;

    public Philosopher(int id, Chopstick l, Chopstick r){
        this.id = id;
        this.left = l;
        this.right = r;
    }
}
