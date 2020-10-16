package Test;

import java.util.Scanner;

public class Bertand {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sosu;
		while(true) {
			sosu = new int[100000];
			int n = sc.nextInt();
			if(n==0) break;
			
			sosu[0] = 2;
			int ans = 0;
			int count = 1;
			int j;
			if(n<2) ans++;
			
			for (int i = 3; i < 2*n; i+=2) {
				j=0;
				while(true) {
					if(sosu[j]>Math.sqrt(i)) {
						sosu[count] = i;
						count++;
						if(i>n) {
							ans++;
						}
						break;
					}else if(i%sosu[j]==0) {
						break;
					}
					j++;
				}
			}
			System.out.println(ans);
		}
	}
}
