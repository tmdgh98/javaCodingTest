package backjun.Greedy;

import java.util.Scanner;

public class Coin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int max = sc.nextInt();
		int[] arr= new int[n];
		for (int i = n-1; i >= 0; i--) {
			arr[i] = sc.nextInt();
		}
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if(max>=arr[i]) {
				max = max-arr[i];
				count++;
				i--;
				if(max==0) {
					break;
				}
			}
		}
		System.out.println(count);
	}
}
