package backjun.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		int sister = sc.nextInt();
		int count = 0;
		boolean[] visit = new boolean[100000+1];
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {subin,0});
		while(subin!=sister) {
			int[] q = que.poll();
			subin = q[0];
			count = q[1];
			if(visit[subin]) continue;
			
			visit[subin]= true;
			
			if(subin<50001)
			que.offer(new int[] {subin*2,count+1});
			if(subin<100000)
			que.offer(new int[] {subin+1,count+1});
			if(subin>0)
			que.offer(new int[] {subin-1,count+1});
		}
		
		System.out.println(count);
	}
}
