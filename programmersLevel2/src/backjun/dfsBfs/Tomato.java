package backjun.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	private static String[][] tomato;
	private static int[][] cnt; 
	private static boolean[][] visit;
	private static Queue<int[]> que = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		tomato = new String[x][y];
		visit = new boolean[x][y];
		cnt = new int[x][y];
		for (int i = 0; i < x; i++) {
			tomato[i] = br.readLine().split(" ");
		}
		
		for(int i=0; i<x; i++) {
			for (int j = 0; j < y; j++) {
				if(tomato[i][j].equals("1")) {
					int[] q = {i,j,1};
					que.offer(q);
				}
			}
		}
		int max=0;
		ripe();
		loop:
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if(cnt[i][j]==0&&!tomato[i][j].equals("-1")) {
					max = -1; 
					break loop;
				}else {
					max = Math.max(max, cnt[i][j]);
				}
			}
			
		}
		
		System.out.println(max==-1?-1:max-1);
	}
	private static void ripe() {
		//Queue<Integer> q = new LinkedList<Integer>();
		while(!que.isEmpty()) {
			int[]q=que.poll();
			int x=q[0];
			int y=q[1];
			int count = q[2];
			if(visit[x][y]) continue;
			
			visit[x][y] = true;
			
			if(!tomato[x][y].equals("-1")) {
				if(cnt[x][y]==0) {
					cnt[x][y]=count;
				}else if(cnt[x][y]<count){
					continue;
				}else {
					cnt[x][y] = Math.min(cnt[x][y], count);	
				}
				if(x>0) {
					int[] next = {x-1,y,count+1};
					que.offer(next);
				}
				if(y>0) {
					int[] next = {x,y-1,count+1};
					que.offer(next);
				}
				if(x<tomato.length-1) {
					int[] next = {x+1,y,count+1};
					que.offer(next);
				}
				if(y<tomato[x].length-1) {
					int[] next = {x,y+1,count+1};
					que.offer(next);
				}
				
			}
			
		}
	}
}
