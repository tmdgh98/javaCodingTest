package baekjoon.dfsBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Numbering {
	private static boolean[][] visit;
	private static String[][] number;
	private static int cnt;
	private static int size;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
		visit = new boolean[n][n];
		number = new String[n][n];
		for (int i = 0; i < n; i++) {
			number[i] = br.readLine().split("");
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visit[i][j]) continue;
				
				if(number[i][j].equals("1")) {
					cnt++;
					size=0;
					find(i,j);
					list.add(size);
				}else {
					visit[i][j]=true;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}
	}
	private static void find(int i, int j) {
		if(visit[i][j]) return;
		visit[i][j]=true;
		
		if(number[i][j].equals("1")) {
			size++;
			if(i>0) find(i-1,j);
			if(j>0) find(i,j-1);
			if(i<visit.length-1) find(i+1,j);
			if(j<visit[i].length-1) find(i,j+1);
		}
	}
}
