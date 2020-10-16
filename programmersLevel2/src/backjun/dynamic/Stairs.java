package backjun.dynamic;

import java.util.Scanner;

public class Stairs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int num = findN(1,0,n,1);
		int[][] arr = new int[n][3];
		//x = 0, o = 1, oo = 2
		//x > o / 0>1 /oo>x 2>0/ o>x,oo / 1>0,2
		int score = sc.nextInt();
		arr[0][0]=0;
		arr[0][1]=score;
		arr[0][2]=0;
		for (int i = 1; i < n; i++) {
			score = sc.nextInt();
			arr[i][1] = score+arr[i-1][0];
			arr[i][2] = score+arr[i-1][1];
			arr[i][0] = Math.max(arr[i-1][1], arr[i-1][2]);
		}
		
		System.out.println(Math.max(arr[n-1][1], arr[n-1][2]));
	}
}
//	public static int findN(int o, int x, int n, int c) {
//		
//		int temp = o;
//		o = x+o;
//		x = temp;
//		if(c==n) {
//			return o+x;
//		}else {
//			return findN(o,x,n,c+1);
//		}
//	}

