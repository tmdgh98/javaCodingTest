package backjun.dfsBfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {
	private static LinkedList<Integer>[] tree;
	private static boolean[] visit;
	private static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();
		int line = sc.nextInt();
		tree = new LinkedList[node+1];
		visit = new boolean[node+1];
		for (int i = 0; i < node+1; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < line; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			tree[node1].add(node2);
			tree[node2].add(node1);
			
			Collections.sort(tree[node1]);
			Collections.sort(tree[node2]);
		}
		bfs(1);
		System.out.println(cnt-1);
	}
	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(i);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			if(visit[node]) continue;
			visit[node]=true;
			
			cnt++;
			for(int next : tree[node]) {
				queue.offer(next);
			}
		}
	}
}
