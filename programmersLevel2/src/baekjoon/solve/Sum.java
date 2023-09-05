package baekjoon.solve;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] num = sc.next().split("");
		
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += Integer.parseInt(num[i]);
		}
		
		System.out.println(sum);
	}
}
