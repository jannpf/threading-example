package Disposition;

public class Worker extends Thread {
    final Warehouse target;
    int currentItem;

    public Worker(Warehouse target) {
        this.target = target;
    }

    @Override
    public void run() {
        while(true) {
            try {
                synchronized (target) {
                    try {
                        currentItem = target.retrieve();
                    } catch (InterruptedException e) {
                        break;
                    } catch (NoMoreWorkException e) {
                        continue;
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": Retrieved item no " + currentItem);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(Thread.currentThread().getName() + ": Conflict!");
            }
        }
    }
}
