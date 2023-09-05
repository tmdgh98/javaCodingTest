package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리 지름구하기
 *
 * bfs를 활용한 방법인데 지름구하는법은 외워야된다
 *
 * 시간줄이는 과정
 * 1. 시간신경안쓰면 그냥 모든 노드에서 최대값을구한후 최대값의 최대값도 답은 나온다...
 * 2. 모든노드에서 -> 리프노드만 찾아서 구해봤다 그래도 시간초과
 * 3. 트리지름구하는 방법 검색해서 해결했다....
 *
 * 트리 지름 구하기
 * 1. 임의의 점점 x에서 가장 먼 정점 y를 찾는다
 * 2. y에서 가장먼 z를 찾는다
 * y~z가 트리의 지름이다
* */

public class BeakJoon1167 {
    static Map<Integer, List> map;
    static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());
        map = new HashMap<>();


        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());

            int key = Integer.parseInt(st.nextToken());
            map.put(key, new ArrayList<int[]>());

            int node = Integer.parseInt(st.nextToken());
            while (node != -1) {
                int len = Integer.parseInt(st.nextToken());
                map.get(key).add(new int[]{node, len});

                node = Integer.parseInt(st.nextToken());
            }
        }


        int[] res = fnGetMaxNode_Len(1);
        res = fnGetMaxNode_Len(res[1]);


        System.out.println(res[0]);
    }

    private static int[] fnGetMaxNode_Len(int node) {
        Queue<Integer> que = new LinkedList<>();
        boolean visit[] = new boolean[v + 1];
        int[] lens = new int[v + 1];
        int max = 0;
        int maxNode = 0;

        que.add(node);
        visit[node] = true;

        while (que.isEmpty() == false) {
            int nextNode = que.poll();

            List<int[]> list = map.get(nextNode);
            for (int[] listItem : list) {
                if (visit[listItem[0]]) {
                    continue;
                }

                visit[listItem[0]] = true;
                lens[listItem[0]] = lens[nextNode] + listItem[1];
                //max = Math.max(max, lens[listItem[0]]);

                if(max < lens[listItem[0]]){
                    max = lens[listItem[0]];
                    maxNode = listItem[0];
                }

                que.add(listItem[0]);
            }
        }

        return new int[]{max,maxNode};
    }
}
