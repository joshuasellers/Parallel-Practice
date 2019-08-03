public class Chopstick {
    private int id;
    private boolean held;

    public Chopstick(int id){
        this.id = id;
        this.held = false;
    }

    public synchronized void pickUp(){
        System.out.printf("Picked up %d", this.id);
        this.held = true;
    }

    public synchronized void putDown(){
        System.out.printf("Put down %d", this.id);
        this.held = false;
    }
}

