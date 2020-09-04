package Disposition;

public class Supplier {
    final Warehouse target;
    int counter = 0;
    public Supplier(Warehouse target) {
        this.target = target;
    }

    public void supply(int noItems) {
        for(int i = 0; i < noItems; i++) {
            target.addItem(++counter);
            System.out.println("Supplier: Added item no " + counter);
        }
    }
}
