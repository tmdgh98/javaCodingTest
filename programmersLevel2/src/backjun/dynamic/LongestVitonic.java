package backjun.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestVitonic {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr= br.readLine().split(" ");
		int[] front = new int[n];
		int[] back = new int[n];
		int[] sequence = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(arr[i]);
			front[i] = 1;
			back[i] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(sequence[i]>sequence[j]) {
					front[i]=Math.max(front[i], front[j]+1);
				}
				if(sequence[n-1-i]>sequence[n-1-j]) {
					back[n-1-i] = Math.max(back[n-1-i], back[n-1-j]+1);
				}
			}
		}	
		for (int i = 0; i < n; i++) {
			front[i] = front[i]+back[i];
			if(max<front[i]) {
				max=front[i];
			}
		}
		System.out.println(max-1);
	}
}
