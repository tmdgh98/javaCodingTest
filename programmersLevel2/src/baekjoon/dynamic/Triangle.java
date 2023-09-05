package baekjoon.dynamic;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] sum1 = new int[n];
		int[] sum2 = new int[n];
		int max=sc.nextInt();
		sum1[0] = max;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				arr[j]=sc.nextInt();
			}
			for (int j = 0; j <= i; j++) {
				if(i%2==1) {
					if(j==0) {
						sum2[0]=sum1[0]+arr[0];
					}else if(j==i) {
						sum2[j]=sum1[j-1]+arr[j];
					}else {
						sum2[j]=arr[j]+Math.max(sum1[j], sum1[j-1]);
					}
					if(i==n-1) {
						if(max<sum2[j]) {
							max = sum2[j];
						}
					}
				}else {
					if(j==0) {
						sum1[0]=sum2[0]+arr[0];
					}else if(j==i) {
						sum1[j]=sum2[j-1]+arr[j];
					}else {
						sum1[j]=arr[j]+Math.max(sum2[j], sum2[j-1]);
					}
					if(i==n-1) {
						if(max<sum1[j]) {
							max = sum1[j];
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
