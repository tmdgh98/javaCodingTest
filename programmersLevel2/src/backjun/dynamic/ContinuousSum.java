package backjun.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class ContinuousSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = sc.nextInt();
//		int[][] arr = new int[n][n];
		int n= Integer.parseInt(br.readLine());
//		int[] arr= new int[n];
		String[] arr = br.readLine().split(" ");
		int max = -1000;
//		int num = n;
//		for (int i = 0; i < n; i++) {
//			arr[i]=sc.nextInt();
//		}
		int sum=0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum += Integer.parseInt(arr[j]);
				
				if(max<sum) {
					max=sum;
				}
				
			}
			sum=0;
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < num; j++) {
//				if(i==0) {
//					arr[i][j]=sc.nextInt();
//				}else if(i==1) {
//					arr[i][j]=arr[i-1][j]+arr[i-1][j+1];
//				}else {
//					arr[i][j]=arr[i-1][j]+arr[i-1][j+1]-arr[i-2][j+1];
//				}
//				if(max<arr[i][j]) {
//					max=arr[i][j];
//				}
//			}
//			num--;
//		}
		System.out.println(max);
	}
}
