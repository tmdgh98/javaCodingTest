package baekjoon.DivideAndConquer;

import java.util.Scanner;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class Multiple {
	
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] arr = br.readLine().split(" ");
//		long a = Integer.parseInt(arr[0]);
//		long b = Integer.parseInt(arr[1]);
//		long c = Integer.parseInt(arr[2]);
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		
		
		long ans = fast(a%c,b,c);
		
		System.out.println(ans);
	}
	private static long fast(long a, long b, long c) {
		if(b==1) {
			return a%c;
		}
		//fast(a,b/2,c) 한번만실행
		long temp = fast(a,b/2,c);
		if(b%2==0) {
			return (temp*temp)%c;
		}else {
			return ((temp*temp%c)*a)%c;
		}	
		//fast(a,b/2,c) 4번실행 시간복잡도 차이가 심함
//		if(b%2==0) {
//			return (fast(a,b/2,c)*fast(a,b/2,c))%c;
//		}else {
//			return ((fast(a,b/2,c)*fast(a,b/2,c)%c)*a)%c;
//		}	
	}
}
