import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
        Map<Integer, Thread> eaters = new HashMap<>();
        while(true){
            int r = ThreadLocalRandom.current().nextInt(0,len);
            if (!eaters.containsKey(r)) {
                System.out.printf("Philosopher %d is hungry\n", philosophers.get(r).getId());
                Thread t = new Thread(philosophers.get(r));
                t.start();
                eaters.put(r,t);
            }
            else{
                if (!eaters.get(r).isAlive()){
                    System.out.printf("Philosopher %d is hungry\n", philosophers.get(r).getId());
                    Thread t = new Thread(philosophers.get(r));
                    t.start();
                    eaters.put(r,t);
                }
            }
        }

    }
}
