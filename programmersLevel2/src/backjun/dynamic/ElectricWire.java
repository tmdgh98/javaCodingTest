package backjun.dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ElectricWire {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] wire = new int[n][2];
		int[] count = new int[n];
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			wire[i][0] = sc.nextInt();
			wire[i][1] = sc.nextInt();
			count[i] = 1;
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(wire[i][1]>wire[j][1]) {
					count[i] = Math.max(count[i], count[j]+1);
				}
			}
			if(max<count[i]) {
				max = count[i];
			}
		}
		
		System.out.println(n-max);
	}
}
