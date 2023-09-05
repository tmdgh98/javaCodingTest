package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon11779 {

    static class Node {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static class Distinct {
        int distinct;
        List<Integer> nodes;

        Distinct(int distinct) {
            this.distinct = distinct;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //도시수
        int m = Integer.parseInt(br.readLine()); //버스노선수

        List<List<Node>> graph = new ArrayList<>(); //버스노선 그래프

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>()); //그래프 초기화
        }

        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); //시작도시
        int end = Integer.parseInt(st.nextToken());   //도착도시

        Distinct[] distinct = new Distinct[n + 1];    //시작도시기준 거리
        boolean[] visit = new boolean[n + 1]; //방문여부기록
        for (int i = 0; i < n + 1; i++) {
            distinct[i] = new Distinct(Integer.MAX_VALUE);
            distinct[i].nodes = new ArrayList<>();
            distinct[i].nodes.add(i);
        }

        Queue<Integer> que = new LinkedList<>();
        distinct[start].distinct = 0;
        que.add(start);
        visit[start] = true;

        int index, cost, min, nextIndex;
        while (que.isEmpty() == false) {
            index = que.poll();
            for (Node node : graph.get(index)) {
                if (distinct[index].distinct + node.cost < distinct[node.index].distinct) {
                    distinct[node.index].distinct = distinct[index].distinct + node.cost;
                    distinct[node.index].nodes = new ArrayList<>(distinct[index].nodes);
                    distinct[node.index].nodes.add(node.index);
                }
            }

            min = Integer.MAX_VALUE;
            nextIndex = 0;
            for (int i = 0; i < n + 1; i++) {
                if (visit[i] == false && distinct[i].distinct < min) {
                    min = distinct[i].distinct;
                    nextIndex = i;
                }
            }

            if (min != Integer.MAX_VALUE) {
                que.add(nextIndex);
                visit[nextIndex] = true;
            }
        }

        sb.append(distinct[end].distinct);
        sb.append("\n");
        sb.append(distinct[end].nodes.size());
        sb.append("\n");
        for (Integer node : distinct[end].nodes) {
            sb.append(node);
            sb.append(" ");
        }

        System.out.println(sb);
    }

}
