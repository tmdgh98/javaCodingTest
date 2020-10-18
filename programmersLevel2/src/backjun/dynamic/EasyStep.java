package backjun.dynamic;

import java.util.Scanner;

public class EasyStep {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[][] arr = new long[n+1][10];
		for (int i = 1; i < 10; i++) {
			arr[0][i] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				if(j==0) {
					arr[i+1][j+1]+=arr[i][j]%1000000000;
				}else if(j==9) {
					arr[i+1][j-1]+=arr[i][j]%1000000000;
				}else {
					arr[i+1][j+1]+=arr[i][j]%1000000000;
					arr[i+1][j-1]+=arr[i][j]%1000000000;
				}
			}
		}
		long sum=0;
		for (int i = 0; i < 10; i++) {
			sum += arr[n-1][i];
			sum %= 1000000000;
		}
		System.out.println(sum);
	}
}
