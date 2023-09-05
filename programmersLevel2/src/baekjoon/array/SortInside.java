package baekjoon.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortInside {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] n = sc.next().split("");
		Arrays.sort(n,Collections.reverseOrder());
		
		String ans="";
		for(String i : n) {
			ans += i;
		}
		System.out.println(ans);
	}
}
