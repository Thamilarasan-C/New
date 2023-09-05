package Inheritance;

public class Main {
    public static void main(String args[]) {

        Shape s1 = new Shape();
        s1.draw("Square", 25);
        s1.details();

        Circle c1 = new Circle();
        c1.details();

        Rectangle r1 = new Rectangle();
        r1.draw("Rectangle", 24);
        r1.fillColour("Blue");
        r1.details();

    }
}
