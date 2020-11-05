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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		tomato = new String[x][y];
		cnt = new int[x][y];
		for (int i = 0; i < x; i++) {
			tomato[i] = br.readLine().split(" ");
		}
		
		for(int i=0; i<x; i++) {
			for (int j = 0; j < y; j++) {
				if(tomato[i][j].equals("1")) {
					visit = new boolean[x][y];
					ripe(i,j);
				}
			}
		}
		int max=0;
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
	private static void ripe(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		//Queue<Integer> q = new LinkedList<Integer>();
		int count = 1;
		boolean first = true;
		int[] q = {x,y,count};
		que.offer(q);
		while(!que.isEmpty()) {
			q=que.poll();
			x=q[0];
			y=q[1];
			count = q[2];
			if(visit[x][y]) continue;
			
			visit[x][y] = true;
			
			if(first||tomato[x][y].equals("0")) {
				first=false;
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
