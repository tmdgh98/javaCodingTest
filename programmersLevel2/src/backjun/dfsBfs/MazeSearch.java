package backjun.dfsBfs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MazeSearch {
	private static String[][] maze;
	private static boolean[][] visit;
	private static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		maze = new String[x][y];
		visit = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			maze[i]= sc.next().split("");
		}
		
		search(0,0);
		Collections.sort(list);
		System.out.println(list.get(0));
	}
	private static void search(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		int[] p = {x,y,0};
		int cnt;
		que.offer(p);
		
		while(!que.isEmpty()) {
			p = que.poll();
			x = p[0];
			y = p[1];
			cnt = p[2];
			if(visit[x][y]) continue;
			
			visit[x][y]=true;
			if(maze[x][y].equals("1")) {
				cnt++;
				if(x==maze.length-1&&y==maze[x].length-1) {
					list.add(cnt);
				}else {
					if(x>0) { 
						int[] next = {x-1,y,cnt};
						que.offer(next);
					}
					if(y>0) { 
						int[] next = {x,y-1,cnt};
						que.offer(next);
					}
					if(x<maze.length-1) { 
						int[] next = {x+1,y,cnt};
						que.offer(next);
					}
					if(y<maze[x].length-1) { 
						int[] next = {x,y+1,cnt};
						que.offer(next);
					}
				}
			}
		}
		
	}
}
