package backjun.solve;

import java.util.Scanner;

public class OneTwoThree {
	private static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			cnt = 0;
			int target = sc.nextInt();
			count(target, 0);
			System.out.println(cnt);
		}
	}

	private static void count(int n, int sum) {
		if (n >= sum) {
			if (sum == n) {
				cnt++;
			} else {
				for (int i = 1; i <= 3; i++) {
					count(n, sum + i);
				}
			}
		}
	}
}
