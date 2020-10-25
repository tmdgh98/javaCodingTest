package backjun.DivideAndConquer;

import java.util.Scanner;

public class Binomial {
	public static void main(String[] args) {
		//이항계수 n!/(r!*(n-r)!) = (n~n-r)/(n~r~1)
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long k = sc.nextInt();
//		1000000007
		long up = multi(1,n);
		long down = multi(1,n-k);
		long down2 = multi(1,k);
		if(n/2>k) {
			up = multi(n-k+1,n);
			down = multi(1,k);
		}else {
			up = multi(k+1,n);
			down = multi(1,n-k);
		}
		
		System.out.println(up/down);
	}

	private static long multi(long start, long last) {
		if(last-start==0) {
			return start%1000000007;
		}else if(last-start==1){
			return (start*last)%1000000007;
		}else {
			long mid =(start+last)/2;
			long temp1 = multi(start,mid);
			long temp2 = multi(mid+1,last);
			return (temp1*temp2)%1000000007;
		}
	}
}
