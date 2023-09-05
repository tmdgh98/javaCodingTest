package baekjoon.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays;
//import java.util.Scanner;

public class Array2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
//		int n = sc.nextInt();
//		int[] num = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
//			num[i] = Integer.parseInt(br.readLine());
			list.add(Integer.parseInt(br.readLine()));
//			num[i] = sc.nextInt();
		}
		Collections.sort(list);
		for(int i : list) {
			bw.write(i+"\n");
		}
		bw.flush();
		
	}
}
