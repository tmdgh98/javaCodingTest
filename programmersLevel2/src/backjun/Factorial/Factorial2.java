package backjun.Factorial;

import java.util.Scanner;

public class Factorial2 {
	public static int count = 2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int point = sc.nextInt();
		int ans = fibonacci(point);
		System.out.println(ans);
	}
	
	public static int fibonacci(int point) {
		if(point==0) {
			return 0;
		}else if(point == 1||point==2) {
			return 1;
		}else {
			return fibo(point, 1, 1);
		}
	}
	private static int fibo(int point, int a, int b) {
		count++;
		if(count==point) {
			return a+b;
		}else {
			a = a+b; 
			return fibo(point, b, a);
		}
	}
}
