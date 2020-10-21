package backjun.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i]+arr[i-1];
		}
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i]+arr[i-1];
		}
		System.out.println(arr[n-1]);
	}
}
