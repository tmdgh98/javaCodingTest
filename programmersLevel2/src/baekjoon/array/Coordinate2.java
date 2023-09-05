package baekjoon.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Coordinate2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] in;
		int[][] num = new int[n][2];
		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			num[i][0]=Integer.parseInt(in[0]);
			num[i][1]=Integer.parseInt(in[1]);
		}
		
		Arrays.sort(num, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}else
					return Integer.compare(o1[1], o2[1]);
			}
			
		});
		
		for(int[] i : num) {
			bw.write(i[0] + " "+i[1]+"\n");
		}
		bw.flush();
	}
	
}
