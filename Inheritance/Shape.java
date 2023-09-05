package Inheritance;

public class Shape {
    String name;
    int area;

    public void draw(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public void changeArea(int area) {
        this.area = area;
    }

    public void details() {
        System.out.println("Name of the shape :" + name);
        System.out.println("Area of " + name + " : " + area);
    }
}
