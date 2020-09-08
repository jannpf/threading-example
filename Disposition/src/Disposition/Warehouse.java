package Disposition;

import java.util.ArrayList;
import java.util.Random;

public class Warehouse {
    ArrayList<Integer> products = new ArrayList<>();
    Random rnd = new Random();

    public Warehouse(int amount) {
        for (int i = 0; i < amount; i++) {
            products.add(i + 1);
        }
    }

    //Processes, retrieves and returns one item from the warehouse
    public int retrieve() throws InterruptedException, NoMoreWorkException {
        int noItems = products.size();
        if (noItems == 0) {
            wait();
        }
        if (noItems > 0) {
            processItem();
            return products.remove(noItems - 1);
        } else throw new NoMoreWorkException();
    }

    //Process one item
    //Takes anywhere between 200 and 400 ms
    public void processItem() {
        try {
            Thread.sleep(rnd.nextInt(200) + 200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void addItem(int item) {
        products.add(item);
        notify();
    }
}
