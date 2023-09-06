package Assignments;

import java.util.*;

public class NestedInterfaceException {

    public static void main(String args[]) {
        NestedCalci.Calculator calci = new Calci();
        calci.add(3, 3.3);
        calci.divide(5, 0);

        try {
            calci.divide1(5, 0);
        } catch (RuntimeException e) {
            System.out.println("Exception handled in main which was thrown by divide1 method");
        }
        System.out.println("Done");
    }
}

interface NestedCalci {

    interface Calculator {

        public void add(int n1, int n2, int n3);

        public void add(double n1, double n2);

        public void add(int n1, int n2);

        public void sub(int n1, int n2);

        public void multiply(int n1, int n2);

        public void divide(int n1, int n2);

        public void divide1(int n1, int n2);
    }
}

class Calci implements NestedCalci.Calculator {

    public void add(double n1, double n2) {
        System.out.println("Addition of two numbers in double : " + (n1 + n2));
    }

    public void divide(int n1, int n2) {
        try {
            int ans = n1 / n2;
            System.out.println("Division : " + ans);
        } catch (RuntimeException e) {
            System.out.println("Exception found and handled in divide method");
        }
    }

    public void divide1(int n1, int n2) throws RuntimeException {
        if (n2 == 0)
            throw new RuntimeException();
        else
            System.out.println("Division : " + (n1 / n2));
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

}