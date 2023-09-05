package baekjoon.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Array3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[10000];
		int[] array = new int[n];
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
			count[array[i]-1]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i]=count[i]+count[i-1];
		}
		for (int i = 0; i < array.length; i++) {
			answer[count[array[i]-1]-1]=array[i];
			count[array[i]-1]--;
		}
		for(int i : answer) {
			bw.write(i+"\n");
		}
		bw.flush();
	}
}
