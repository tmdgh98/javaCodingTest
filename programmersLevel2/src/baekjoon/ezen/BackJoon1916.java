package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon1916 {

    static class Node {
        int index;
        int cost;

        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //도시수
        int m = Integer.parseInt(br.readLine()); //버스수

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int a,b,c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int goal =  Integer.parseInt(st.nextToken());

        int[] distinct = fnDijkstra(start,graph);

        System.out.println(distinct[goal]);

    }

    private static int[] fnDijkstra(int start, List<List<Node>> graph) {
        int n = graph.size();
        int[] distinct = new int[n];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(distinct, inf);
        distinct[start] = 0;

        boolean[] visit = new boolean[n];
        Queue<Integer> que = new LinkedList<>();

        que.add(start);

        while (que.isEmpty() == false){
            int index = que.poll();
            visit[index] = true;

            for (Node node : graph.get(index)) {
                distinct[node.index] = Math.min(distinct[index]+node.cost, distinct[node.index]);
            }

            int nextIndex = 0;
            int minDistinct = inf;

            for (int i = 0; i < distinct.length; i++) {
                if(visit[i] == false && distinct[i] < minDistinct){
                    nextIndex = i;
                    minDistinct = distinct[i];
                }
            }

            if(minDistinct != inf){
                que.add(nextIndex);
            }
        }

        return distinct;
    }

}
