package backjun.dynamic;

import java.util.Scanner;

public class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int maximumWeight = sc.nextInt();
		int[] arr = new int[maximumWeight+1];
		int weight;
		int value;
		int max=0;
		for (int i = 0; i < n; i++) {
			weight = sc.nextInt();
			value = sc.nextInt();
			for (int j = 0; j < arr.length-weight; j++) {
				if(j+weight<=maximumWeight)
				arr[j+weight]=Math.max(arr[j+weight], value+arr[j]);
				if(max<arr[j+weight]) {
					max = arr[j+weight];
				}
			}
		}
		System.out.println(max);
	}
}
