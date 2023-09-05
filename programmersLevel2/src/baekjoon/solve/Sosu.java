package baekjoon.solve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sosu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		int[] num = new int[n];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		boolean sosu;
		for (int i = 2; i < num[n-1]; i++) {
			sosu = true;
			for (int j = 0; j < list.size(); j++) {
				if(i%list.get(j)!=0) {
					sosu = false;
					break;
				}
			}
			if(sosu) {
				
			}
		}
	}
}
