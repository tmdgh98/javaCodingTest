package backjun.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Statistics {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[4];
		int sum=0;
		int max;
		int min;
		int countmax=-1;
		int count=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
			sum += list.get(i);
		}
		double avg = sum/(double)n;
		answer[0] = (int) Math.round(avg);
		Collections.sort(list);
		answer[1] = list.get(list.size()/2);
		min = list.get(0);
		max = list.get(list.size()-1);
		answer[3] = max - min;
		int[] counting = new int[answer[3]+1];
		for(int i : list) {
			counting[i-min]++;
		}
		for (int j = 0; j < counting.length; j++) {
			
			if(countmax<counting[j]) {
				count=0;
				countmax = counting[j];
				answer[2] = j+min;
			}else if(countmax == counting[j]&&count==0) {
				count++;
				answer[2] = j+min;
			}
		}
		for(int i : answer) {
			bw.write(i+"\n");
		}
		bw.flush();
	}
}
