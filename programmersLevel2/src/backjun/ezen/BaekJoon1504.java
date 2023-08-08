package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1504 {

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

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드수
        int m = Integer.parseInt(st.nextToken()); //간선수

        int inf = Integer.MAX_VALUE;

        int[][] distinct = new int[n+1][n+1];
        for (int[] dis : distinct) {
            Arrays.fill(dis, inf);
        }

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        int a;
        int b;
        int c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[n+1];
        Queue<Integer> que = new LinkedList<>();

        int[] arr = {1, u, v};
        for (int start : arr) {
            Arrays.fill(visit,false);
            que.add(start);
            distinct[start][start] = 0;

            while (que.isEmpty() == false){
                int index = que.poll();
                visit[index] = true;

                for (Node node : graph.get(index)) {
                    distinct[start][node.index] = Math.min( node.cost + distinct[start][index] , distinct[start][node.index] );
                }

                int nextIndex = 0;
                int min = inf;
                for (int j = 0; j < n+1; j++) {
                    if(visit[j] == false && distinct[start][j] < min){
                        nextIndex = j;
                        min = distinct[start][j];
                    }
                }

                if(min != inf){
                    que.add(nextIndex);
                }
            }
        }


        long res = (long) distinct[1][u] + distinct[u][v] + distinct[v][n];
        long res2 = (long) distinct[1][v] + distinct[v][u] + distinct[u][n];

        res = Math.min(res,res2);

        if(res >= inf){
            sb.append("-1");
        }else{
            sb.append(res);
        }

        System.out.println(sb);

    }

}
