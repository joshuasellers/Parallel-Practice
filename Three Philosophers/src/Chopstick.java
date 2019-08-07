public class Chopstick {
    private int id;
    private boolean held;

    public Chopstick(int id){
        this.id = id;
        this.held = false;
    }

    public boolean getHeld(){
        return this.held;
    }

    public synchronized boolean pickUp(int p){
        if (this.held){
            System.out.printf("Chopstick %d is already held, sorry philosopher %d \n",this.id, p);
            return false;
        }
        else {
            System.out.printf("Philosopher %d picked up chopstick %d\n", p, this.id);
            this.held = true;
            return true;
        }
    }

    public synchronized void putDown(int p){
        if (!this.held){
            System.out.printf("Chopstick %d is already on the table, sorry philosopher %d \n",this.id,p);
        }
        else {
            System.out.printf("Philosopher %d put down chopstick %d\n", p, this.id);
            this.held = false;
        }
    }
}

