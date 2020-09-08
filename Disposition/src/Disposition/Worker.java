package Disposition;

public class Worker extends Thread {
    final Warehouse target;
    int currentItem;

    public Worker(Warehouse target) {
        this.target = target;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Begin synchronized context
                //Conflicts arise if removed
                synchronized (target) {
                    try {
                        currentItem = target.retrieve();
                    } catch (InterruptedException e) {
                        //Thread aborted
                        break;
                    } catch (NoMoreWorkException e) {
                        //Restart
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
