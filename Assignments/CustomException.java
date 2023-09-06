package Assignments;

public class CustomException {
    public static void main(String args[]) {
        CustomException ce = new CustomException();
        try {
            ce.checkTwoDigits(444);
        } catch (NotATwoDigitNumber a) {
            System.out.println(a.getMessage());
            System.out.println("Handled in main using try catch");
        }

    }

    public void checkTwoDigits(int n) throws NotATwoDigitNumber {
        if (n > 9 && n < 100)
            System.out.println("It's a two digit number");
        else
            throw new NotATwoDigitNumber("Its not a two Digit number");
    }
}

class NotATwoDigitNumber extends Exception {
    NotATwoDigitNumber(String m) {
        super(m);
    }

}
