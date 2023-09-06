package InterfaceAndClass;

import java.util.*;

public class Calci implements Calculator {

    public void add(double n1, double n2) {
        System.out.println("Addition of two numbers in double : " + (n1 + n2));
    }

    public void add(int n1, int n2) {
        System.out.println("Addition of two numbers : " + (n1 + n2));
    }

    public void add(float n1, float n2) {
        System.out.println("Addition of two numbers in float : " + (n1 + n2));

    }

    public void add(int n1, int n2, int n3) {
        System.out.println("Addition of three numbers : " + (n1 + n2 + n3));
    }

    public void sub(int n1, int n2) {
        System.out.println("Subtraction :" + (n1 - n2));
    }

    public void multiply(int n1, int n2) {
        System.out.println("Multiplication : " + (n1 * n2));
    }

    public void divide(int n1, int n2) {
        System.out.println("Division : " + n1 / n2);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Calculator calci = new Calci();
        calci.add(3, 2);
        calci.add(2, 3, 4);
        calci.add(2.3, 3.3);
        calci.add(3, 3.3);

    }
}
