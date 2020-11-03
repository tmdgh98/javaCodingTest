package backjun.dfsBfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage {
	private static int[][] cabbage;
	private static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			cabbage = new int[x][y];
			visit = new boolean[x][y];
			for (int j = 0; j < num; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				cabbage[x][y]=1;
			}
			int bugs = 0;
			for (int j = 0; j < cabbage.length; j++) {
				for (int j2 = 0; j2 < cabbage[j].length; j2++) {
					if(visit[j][j2]) continue;
					
					if(cabbage[j][j2]==1) {
						bugs++;
						findBug(j,j2);
					}else {
						visit[j][j2] = true;
					}
				}
			}
			sb.append(bugs+"\n");
		}
		System.out.println(sb);
	}
//	private static void findBug(int x, int y) {
//		Queue<Point> queue = new LinkedList<Point>();
//		Point p = new Point(x, y);
//		queue.offer(p);
//		
//		while(!queue.isEmpty()) {
//			p = queue.poll();
//			x = p.x;
//			y = p.y;
//			if(visit[x][y]) continue;
//			
//			visit[x][y] = true;
//			
//			if(cabbage[x][y]==1) {
//				if(x>0) queue.offer(new Point(x-1,y));
//				if(y>0) queue.offer(new Point(x,y-1));
//				if(x<cabbage.length-1) queue.offer(new Point(x+1,y));
//				if(y<cabbage[x].length-1) queue.offer(new Point(x,y+1));
//			}
//		}
//	}
	
	//dfs 재귀 오버플로우
	private static void findBug(int x, int y) {
		if(visit[x][y]) return;
		
		visit[x][y]=true;
		if(cabbage[x][y]==1) {
			if(x>0) findBug(x-1,y);
			if(y>0) findBug(x,y-1);
			if(x<cabbage.length-1) findBug(x+1,y);
			if(y<cabbage.length-1) findBug(x,y+1);
		}
	}
}
