package Test;

import java.util.Scanner;

public class MandN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] sosu = new int[100000];
		sosu[0] = 2;
		int j;
		int count = 1;
		if(m<=2) {
			sb.append(2+"\n");
		}
		for (int i = 3; i <= n; i+=2) {
			j=0;
			while(true) {
				if(sosu[j]>Math.sqrt(i)) {
					sosu[count] = i;
					count++;
					if(i>=m) {
						sb.append(i + "\n");
					}
					break;
				}else if(i%sosu[j]==0) {
					break;
				}
				j++;
			}
		}
		System.out.println(sb);
	}
}
