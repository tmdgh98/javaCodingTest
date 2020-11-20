package backjun.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MusicalScales {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] music = new int[8];
		for (int i = 0; i < 8; i++) {
			music[i] = Integer.parseInt(st.nextToken());
		}
		
		if(asc(music)) {
			System.out.println("ascending");
		}else if(des(music)) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
	}

	private static boolean asc(int[] music) {
		int[] ascending = {1,2,3,4,5,6,7,8};
		for (int i = 0; i < ascending.length; i++) {
			if(music[i]!=ascending[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean des(int[] music) {
		int[] descending = {8,7,6,5,4,3,2,1};
		for (int i = 0; i < descending.length; i++) {
			if(music[i]!=descending[i]) {
				return false;
			}
		}
		return true;
	}
}
