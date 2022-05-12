package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 너비탐색(BFS) 응용문제
 * 너비탐색 = 큐
 * 깊이탐색 = 스택을 활용해 구현한다.
 *
 * */

public class BeakJoon1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] count = new int[n + 1];
        List<List> user = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            user.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            user.get(a).add(b);
            user.get(b).add(a);
        }


        for (int i = 1; i <= n; i++) {
            Queue<int[]> que = new LinkedList<>();
            boolean[] visit = new boolean[n + 1];
            visit[i] = true;
            List<Integer> friend = user.get(i);
            for (Integer name : friend) {
                int[] temp = {name, 1};
                que.add(temp);
            }
            while (que.isEmpty() == false) {
                int[] temp = que.poll();
                int name = temp[0];
                int c = temp[1];
                if (visit[name] == true) {
                    continue;
                }

                visit[name] = true;
                count[i] += c;
                friend = user.get(name);
                for (Integer tempName : friend) {
                    int[] tempArr = {tempName, c + 1};
                    que.add(tempArr);
                }
            }
        }

        int res = 0;
        int resCount = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                res = i;
                resCount = count[i];
            } else if (resCount > count[i]) {
                res = i;
                resCount = count[i];
            }
        }

        System.out.println(res);
    }
}
