package baekjoon.dfsBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs {
	private static LinkedList<Integer>[] tree;
	private static boolean[] dfs;
	private static boolean[] bfs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sbDfs = new StringBuilder();
		StringBuilder sbBfs = new StringBuilder();
		
		int nodeCnt = Integer.parseInt(st.nextToken());
		int lineCnt = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		tree = new LinkedList[nodeCnt+1];
		dfs = new boolean[nodeCnt+1];
		bfs = new boolean[nodeCnt+1];
		
		for (int i = 0; i < nodeCnt+1; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < lineCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			tree[node1].add(node2);
			tree[node2].add(node1);
			
			Collections.sort(tree[node1]);
			Collections.sort(tree[node2]);
		}
		
		dfs(startNode,sbDfs);
		bfs(startNode,sbBfs);
		
		System.out.println(sbDfs);
		System.out.println(sbBfs);
	}
	private static void bfs(int node, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			node = queue.poll();
			
			if(bfs[node]) continue;
			
			bfs[node] = true;
			sb.append(node+" ");
			for(int next : tree[node]) {
				queue.offer(next);
			}
		}
	}
	private static void dfs(int node, StringBuilder sb) {
		if(dfs[node]) return;
		
		dfs[node]=true;
		sb.append(node+" ");
		for(int next : tree[node]) {
			dfs(next,sb);
		}
	}
}
