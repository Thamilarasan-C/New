package Inheritance;

public class Rectangle extends Shape {
    String colour;

    public void fillColour(String colour) {
        this.colour = colour;
    }

    public void details() {
        super.details();
        System.out.print("Colour of the " + name + ": " + colour);
    }

    public static void main(String args[]) {
        Rectangle r1 = new Rectangle();
        r1.draw("Rectangle", 20);
        r1.details();
        // r1.super.details();
        System.out.println(r1.name);
        // System.out.println(r1.super.name);
    }
}
