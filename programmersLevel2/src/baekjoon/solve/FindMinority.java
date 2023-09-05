package baekjoon.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindMinority {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] minority = new int[arr[n-1]];
		int count = 0;
		minority[0] = 2;
		int idx = 1;
		int aidx = 0;
		if(arr[aidx]==1) aidx++;
		if(arr[aidx]==2) {
			aidx++;
			count++;
		}
		for (int i = 3; i <= arr[n-1]; i++) {
			boolean mino = true;
			for (int j = 0; j < idx; j++) {
				if(i%minority[j]==0) {
					mino = false;
					break;
				}
				if(Math.sqrt(i)<minority[j]) break;
			}
			if(mino) {
				minority[idx]=i;
				idx++;
			}
			if(arr[aidx]==i) {
				aidx++;
				if(mino) count++;
			}
		}
		System.out.println(count);
	}
}
