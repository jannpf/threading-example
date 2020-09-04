package Disposition;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Warehouse to store objects
        Warehouse wh = new Warehouse(10);

        //Workers to process all objects in the warehouse
        Worker w1 = new Worker(wh);
        w1.setName("Worker 1");

        Worker w2 = new Worker(wh);
        w2.setName("Worker 2");

        //Begin
        w1.start();
        w2.start();

        Thread.sleep(5000);

        Supplier sup = new Supplier(wh);
        sup.supply(2);

    }
}
