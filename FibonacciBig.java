import java.math.BigInteger;
import java.util.*;
public class FibonacciBig{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        while(true) 
        {
        String s = sc.next();
        if(!s.equals("exit"))
        {
        int n=Integer.parseInt(s);
        for(int i=0;i<n;i++)
        System.out.print(fib(BigInteger.valueOf(i))+" ");
        System.out.println();
        }
        else
         break;
        }
    }
    public static BigInteger fib(BigInteger n){
        if(n.equals(BigInteger.valueOf(1)) || n.equals(BigInteger.valueOf(0)))
        return n;
        return fib(n.subtract(BigInteger.valueOf(1))).add(fib(n.subtract(BigInteger.valueOf(2))));
    }
}