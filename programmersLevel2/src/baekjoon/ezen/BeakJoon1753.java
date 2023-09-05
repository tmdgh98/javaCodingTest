package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 다익스트라알고리즘 사용문제
 * 구현해서 풀어보려고했으나 시간초과로 실패함
 * <p>
 * 다익스트라검색 알고리즘 검색함
 * <p>
 * https://namu.wiki/w/%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * 다익스트라 알고리즘은 다음과 같다. (P[A][B]는 A와 B 사이의 거리라고 가정한다)
 * 1. 출발점으로부터의 최단거리를 저장할 배열 d[v]를 만들고, 출발 노드에는 0을, 출발점을 제외한 다른 노드들에는 매우 큰 값 INF를 채워 넣는다.
 * (정말 무한이 아닌, 무한으로 간주될 수 있는 값을 의미한다.) 보통은 최단거리 저장 배열의 이론상 최대값에 맞게 INF를 정한다. 실무에서는 보통 d의 원소 타입에 대한 최대값으로 설정하는 편.[6][7]
 * 2. 현재 노드를 나타내는 변수 A에 출발 노드의 번호를 저장한다.
 * 3. A로부터 갈 수 있는 임의의 노드 B에 대해, d[A] + P[A][B][8]와 d[B][9]의 값을 비교한다. INF와 비교할 경우 무조건 전자가 작다.
 * 4. 만약 d[A] + P[A][B]의 값이 더 작다면, 즉 더 짧은 경로라면, d[B]의 값을 이 값으로 갱신시킨다.
 * 5. A의 모든 이웃 노드 B에 대해 이 작업을 수행한다.
 * 6. A의 상태를 "방문 완료"로 바꾼다. 그러면 이제 더 이상 A는 사용하지 않는다.
 * 7. "미방문" 상태인 모든 노드들 중, 출발점으로부터의 거리가 제일 짧은 노드 하나를 골라서 그 노드를 A에 저장한다.
 * 8. 도착 노드가 "방문 완료" 상태가 되거나, 혹은 더 이상 미방문 상태의 노드를 선택할 수 없을 때까지, 3~7의 과정을 반복한다.
 * 이 작업을 마친 뒤, 도착 노드에 저장된 값이 바로 A로부터의 최단 거리이다. 만약 이 값이 INF라면, 중간에 길이 끊긴 것임을 의미한다
 * <p>
 * * 7번 단계에서, 거리가 가장 짧은 노드를 고르는 것은 공짜가 아니다. 모든 노드를 순회해야 하므로 시간복잡도에 결정적인 영향을 미치게 되는데,
 * 이때 제대로 구현된[10] 우선순위 큐를 활용한다면 이 비용을 줄일 수 있다. 최단거리를 갱신할 때 우선순위 큐에도 <위치, 거리>의 쌍을 넣어주고,
 * 거리가 가장 짧은 노드를 우선순위 큐를 이용해 고르면 된다.
 */

public class BeakJoon1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        Map<Integer, List> tree = new HashMap<>();
        int[] lens = new int[n + 1];
        int infi = 10*90000;
        for (int i = 0; i < lens.length; i++) {
            lens[i] = infi;

        }
        boolean[] visit = new boolean[n + 1];

//        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] > o2[0] ? 1 : -1;
//            }
//        });
//        que.add(new int[] {1,2});
//        que.poll();

        int u, v, w;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if (tree.containsKey(u) == false) {
                tree.put(u, new ArrayList<int[]>());
            }
            tree.get(u).add(new int[]{v, w});
        }

        //Queue<Integer> que = new LinkedList<>();
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
        lens[k] = 0;
        que.add(new int[]{k,lens[k]});
        while (que.isEmpty() == false) {
            int[] queItem = que.poll();
            int node = queItem[0];
            int len = queItem[1];
            if (visit[node] == true) {
                continue;
            }
            visit[node] = true;

            List<int[]> list = tree.get(node);
            if (list == null) continue;
            for (int[] listItem : list) {
                int a = listItem[0];
                int b = listItem[1];

                if(lens[a] > lens[node] + b){
                    lens[a] = lens[node] + b;
                    que.add(new int[]{a,lens[a]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            String res = lens[i] == infi ? "INF" : lens[i] + "";
            sb.append(res + "\n");
        }
        System.out.println(sb);
    }
}
