package baekjoon.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MeetingRoom {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]!=o2[1])
					return Integer.compare(o1[1],o2[1]);
				else
					return Integer.compare(o1[0], o2[0]);
			}
		});
		
		int end = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(arr[i][0]>=end) {
				count++;
				end=arr[i][1];
			}
		}
		System.out.println(count);
	}
}
