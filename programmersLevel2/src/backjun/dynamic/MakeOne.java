package backjun.dynamic;

import java.util.Scanner;

public class MakeOne {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for (int i = 1; i < n; i++) {
			if(arr[i+1]==0||arr[i+1]>arr[i]+1) {
				arr[i+1]=arr[i]+1;
			}
			if(n>=i*2&&(arr[i*2]==0||arr[i*2]>arr[i]+1)) {
				arr[i*2]=arr[i]+1;
			}
			if(n>=i*3&&(arr[i*3]==0||arr[i*3]>arr[i]+1)) {
				arr[i*3]=arr[i]+1;
			}
		}
		
		System.out.println(arr[n]);
	}

}
