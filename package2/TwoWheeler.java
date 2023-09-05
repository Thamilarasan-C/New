package package2;

import package1.Vehicle;

public class TwoWheeler extends Vehicle {
    int price;
    int cc;

    public TwoWheeler() {
        System.out.print("in constructor");
    }

    public TwoWheeler(int price, int cc) {
        this();
        this.price = price;
        this.cc = cc;
        System.out.println("Bike");
    }

    public void printDetails() {
        System.out.println("Bike cc" + cc);
        System.out.println("Bike price" + price);

    }

    public static void main(String args[]) {
        TwoWheeler bike = new TwoWheeler(50000, 100);
        bike.printDetails();
        bike.start();
    }
}