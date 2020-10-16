package backjun;

import java.util.Scanner;

public class Factorial1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int fac =1;
		fac = factorial(num, fac);
		System.out.println(fac);
		sc.close();
	}
	public static int factorial(int num,int fac) {
	
		fac = fac*num;
		if(num>1) {
			return factorial(num-1,fac);
		}else if(num==0){
			return 1;
		}else {
			return fac;
		}
	}
}
