package backjun;

import java.util.Scanner;

public class Factorial3 {
//	static int row = 1;
//	static int column = 1;
//	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		num = n;
//		star(num);
		star(n);
	}
	private static void star(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				star2(n,i+1,j+1);
			}
			System.out.println("");
		}
	}
	public static void star2(int n,int i, int j) {
//		int first = n/3;
//		int last = n/3*2;
//		int row = i%n;
//		int column = j%n;
		if(n/3<i%n&&i%n<=n/3*2&&n/3<j%n&&j%n<=n/3*2) {
			System.out.print(" ");
		}else {
			if(n>3)
				star2(n/3,i,j);
			else
				System.out.print('*');
		}
	}
//	private static void star(int n) {
//		int first = n/3;
//		int last = n/3*2;
//		int rown = row%n;
//		int columnn = column%n;
//		if((first<rown&&rown<=last)&&(first<columnn&&columnn<=last))
//			System.out.print(" ");
//		else {
//			if(n>3) {
//				star(n/3);
//			}else {
//				System.out.print("*");
//				n=num;
//			}
//		}
//		if(row<num) {//row
//			row++;
//			star(n);
//		}else if(column<num) {//column
//			column++;
//			row=1;
//			System.out.println("");
//			star(n);
//		}
//	}
	
}
