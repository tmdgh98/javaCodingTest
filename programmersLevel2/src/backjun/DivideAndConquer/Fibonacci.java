package backjun.DivideAndConquer;

import java.util.Scanner;

public class Fibonacci {
	static long[][] matrix = {{1,1},{1,0}};
	public static void main(String[] args) {
		/*	피보나치 수열 행렬버전
		 * ( f(n+1) f(n) ) == ( 1 1 )n
		 * ( f(n) f(n-1) )    ( 1 0 )
		 */
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long[][] answer = fibo(n);
		
		System.out.println(answer[0][1]%1000000);
	}
	public static long[][] fibo(long n) {
		if(n==1) {
			return matrix;
		}
		long[][] temp = fibo(n/2);
		if(n%2==0) {
			return second(temp,temp);
		}else {
			return second(second(temp,temp),matrix);
		}
	}
	public static long[][] second(long[][] matrix1, long[][] matrix2){
		long[][] rematrix = new long[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				long feild = 0;
				for (int j2 = 0; j2 < 2; j2++) {
					feild += matrix1[i][j2]*matrix2[j2][j]%1000000;
				}
				rematrix[i][j] = feild%1000000;
			}
		}
		
		return rematrix;
	}
}
