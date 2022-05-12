package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 그래프 경로탐색
 * 1. 배열을 그래프화
 * 2. 그래프로 너비탐색(BFS) 로 풀었는데
 *
 * 원래는 플로이드-와샬 알고리즘을 사용하는문제였음...
 * */

public class BeakJoon11403_DFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Map<Integer, List> grape = new HashMap<>();
        for (int i = 0; i < n; i++) {
            grape.put(i, new ArrayList<Integer>());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    grape.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int[] res = new int[n];

            Queue<Integer> que = new LinkedList<>();
            List<Integer> list = grape.get(i);
            for (Integer target : list) {
                que.add(target);
            }

            while (que.isEmpty() == false) {
                int key = que.poll();
                if (res[key] == 1) {
                    continue;
                }

                res[key] = 1;

                list = grape.get(key);
                for (Integer target : list) {
                    que.add(target);
                }
            }

            sb.append(Arrays.toString(res).replace("[", "").replace("]", "").replace(",", "") + "\n");
        }

        System.out.println(sb);
    }

}
