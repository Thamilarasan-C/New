import java.util.*;
public class Pattern
{
	public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
	    int n=sc.nextInt();
	    
	    for(int i=1;i<=n;i++)
	    print(n,i,'*');
	    
	    for(int i=n;i>=1;i--)
	    print(n,i,'-');
	}
	static void print(int n,int i,char ch){
	        for(int j=1;j<=i;j++)
	        System.out.print(ch);
	        for(int j=1;j<(2*(n-i));j++)
	        System.out.print(" ");
	        for(int j=1;j<=i;j++)
	        if(j!=n)
	        System.out.print(ch);
	        System.out.println();
	}
}
