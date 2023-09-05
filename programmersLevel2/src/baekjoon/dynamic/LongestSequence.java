package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestSequence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int[] sequence = new int[n];
		int max = 0;
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(arr[i]);
			count[i] =1;
			for (int j = 0; j < i; j++) {
				if(sequence[i]>sequence[j]) {
					count[i] = Math.max(count[i], count[j]+1);
				}
			}
			if(max<count[i]) {
				max = count[i];
			}
		}
		System.out.println(max);
	}
}
