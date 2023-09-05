package baekjoon.solve;

import java.util.Scanner;

public class FirstAlpa {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		String str = sc.next();
		int[] arr = new int[26];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i)-'a';
			if(arr[n]==-1) {
				arr[n] = i;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
