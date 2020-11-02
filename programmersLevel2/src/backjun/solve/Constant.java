package backjun.solve;

import java.util.Scanner;

public class Constant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt(); 
		
		n1 = reversal(n1);
		n2 = reversal(n2);
		
		int ans = n1>n2 ? n1:n2;
		
		System.out.println(ans);
	}
	public static int reversal(int n) {
		int newn = 0;
		while(n>0) {
			newn += n%10;
			newn *= 10;
			n /= 10;
		}
		return newn/10;
	}
}
