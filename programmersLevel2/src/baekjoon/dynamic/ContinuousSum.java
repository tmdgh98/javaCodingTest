package baekjoon.dynamic;

import java.io.IOException;
import java.util.Scanner;

public class ContinuousSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr= new int[n];
		arr[0] = sc.nextInt();
		int max=arr[0];
		int num=arr[0];
		for (int i = 1; i < n; i++) {
			arr[i] = sc.nextInt();
				num=Math.max(arr[i]+arr[i-1],Math.max(arr[i], arr[i]+num));
			if(num>=max) {
				max=num;
			}
			
		}
		
		System.out.println(max);
	}
}
