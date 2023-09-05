package baekjoon.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Coordinate {
	static int[][] x;
	static int[][] temp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] in;
		int n = Integer.parseInt(br.readLine());
		x = new int[n][2];
		temp = new int[n][2]; 
		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");

			x[i][0] = Integer.parseInt(in[0]);
			x[i][1] = Integer.parseInt(in[1]);
		}
//		for (int i = 0; i < x.length; i++) {
//			for (int j = 0; j < x.length; j++) {
//				if(x[i]<x[j]||(x[i]==x[j]&&y[i]<y[j])) {
//					temp=x[i];
//					x[i]=x[j];
//					x[j]=temp;
//					temp=y[i];
//					y[i]=y[j];
//					y[j]=temp;
//				}
//			}
//		}
		merge(0, n-1);
		for (int i = 0; i < x.length; i++) {
			bw.write(x[i][0]+" "+x[i][1]+"\n");
		}
		bw.flush();
		
	}
	
	public static void merge(int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			merge(0,mid);
			merge(mid+1,end);
			
			int p = start;
			int q = mid+1;
			int index = start;
			while(p<=mid||q<=end) {
				if(q>end || (p<=mid&&x[p][0]<x[q][0])) {
					temp[index][0] = x[p][0];
					temp[index++][1] = x[p++][1];
				}else if(p<=mid&&x[p][0]==x[q][0]&&x[p][1]<x[q][1]) {
					temp[index][0] = x[p][0];
					temp[index++][1] = x[p++][1];
				}else {
					temp[index][0] = x[q][0];
					temp[index++][1] = x[q++][1];
				}
			}
			for (int i = start; i <= end; i++) {
				x[i][0] = temp[i][0];
				x[i][1] = temp[i][1];
			}
		}
	}
}
