package backjun.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HistogramSquare {
	static long[] high;
	static long max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] read = br.readLine().split(" ");
			int n = Integer.parseInt(read[0]);
			max = 0;
			if(n==0) {
				break;
			}
			high = new long[n];
			for (int i = 0; i < n; i++) {
				high[i] = Long.parseLong(read[i+1]);
			}
			height(0,n-1);
			
			System.out.println(max);
		}
	}
	public static long height (int start, int last) {
		int mid = (start+last)/2;
		if(start==last) {
			if(max<high[start]) {
				max = high[start];
			}
			return high[start];
		}
		long minFront = height(start, mid);
		long minBack = height(mid+1,last);
		long min = Math.min(minFront, minBack);
		long compare01 = (last-start+1)*min;
		long compare02 = 0;
		int comNum = 0;
		if(min==minBack) {
			comNum = mid-start+1;
			for (int i = mid+1; i <= last; i++) {
				if(minFront>high[i]) {
					break;
				}else {
					comNum++;
				}
			}
			compare02 = comNum*minFront;
		}else {
			comNum = last-mid;
			for (int i = mid; i >= start; i--) {
				if(minBack>high[i]) {
					break;
				}else {
					comNum++;
				}
			}
			compare02 = comNum*minBack;
		}
		long midHigh = Math.min(high[mid], high[mid+1]);
		comNum = 0;
		for (int i = mid+1; i <= last; i++) {
			if(midHigh>high[i]) {
				break;
			}else {
				comNum++;
			}
		}
		for (int i = mid; i >= start; i--) {
			if(midHigh>high[i]) {
				break;
			}else {
				comNum++;
			}
		}
		
		long compare03 = comNum*midHigh;
		
		long temp = Math.max(compare03,Math.max(compare01, compare02));
		if(max<temp) {
			max=temp;
//			System.out.println(start+" "+last+" "+mid+" "+compare01+" "+compare02+" "+compare03);
		}
		return min;
	}
}
