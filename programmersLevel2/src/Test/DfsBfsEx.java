package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DfsBfsEx {
	public static int nodeCnt;
	public static LinkedList<Integer>[] nodeList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nodeCnt = Integer.parseInt(st.nextToken());
		int lineCnt = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		nodeList = new LinkedList[nodeCnt+1];
		
		for(int i=0; i <= nodeCnt; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i< lineCnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			nodeList[node1].add(node2);
			nodeList[node2].add(node1);
			
			Collections.sort(nodeList[node1]);
			Collections.sort(nodeList[node2]);
		}
		StringBuilder sbDfs = new StringBuilder();
		StringBuilder sbBfs = new StringBuilder();
		
		boolena[] 
		
	}
}
