/**
 * 
 */
package baekjoon.backtracking;

import java.util.Scanner;

/**
 * @author oaoa
 *
 */
public class NandM01 {
	static boolean[] visit;
	static int[] array;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		visit = new boolean[n];
		array = new int[m];
		
		backtracking(n,m,0);
	}
	
	public static void backtracking(int n, int m, int depth) {
		if(depth < m) {
			for(int i = 0; i < n; i++) {
				if(visit[i]==false) {
					visit[i] = true;
					array[depth] = i+1;
					backtracking(n,m,depth+1);
					
					visit[i] = false;
				}
			}
		}else {
			for(int i : array) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
