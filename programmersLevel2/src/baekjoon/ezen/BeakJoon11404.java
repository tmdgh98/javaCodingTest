package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 플로이드 와샬 알고리즘
 * 모든경로에서 모든경로의 최단거리를 구하는 알고리즘
 * 
 * 다익스트라 - 한점에서 모든노드 최단거리(음수가중치x)
 * 벨만 포드 - 한점에서 모든노드 최단거리(음수가중치O)
 * 플로이드 와샬 - 모든점에서 모든노드 최단거리
 * */
public class BeakJoon11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long[][] graph = new long[n + 1][n + 1];
        int inf = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], inf);
            graph[i][i] = 0;
        }

        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (graph[a][b] > c) {
                graph[a][b] = c;
            }
        }

        for (int mid = 1; mid < n + 1; mid++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][mid] + graph[mid][j] < graph[i][j]) {
                        graph[i][j] = graph[i][mid] + graph[mid][j];
                    }
                }
            }
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(graph[i][j] == inf){
                    sb.append(0).append(" ");
                }else {
                    sb.append(graph[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
