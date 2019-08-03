import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ArrayList<Philosopher> philosophers = new ArrayList<>();
        ArrayList<Chopstick> chopsticks = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();
        int len = 6;
        for (int i = 0; i < len; i++){
            chopsticks.add(new Chopstick(i));
        }
        for (int i = 0; i < len; i++){
            int l;
            int r;
            if (i ==5){
                l = 0;
                r = 5;
            }
            else{
                l = i + 1;
                r = i;
            }
            Chopstick left = chopsticks.get(l);
            Chopstick right = chopsticks.get(r);
            philosophers.add(new Philosopher(i,left,right));
        }
        while(true){
            int r = ThreadLocalRandom.current().nextInt(0,len);
            new Thread(philosophers.get(r)).start();
        }

    }
}
