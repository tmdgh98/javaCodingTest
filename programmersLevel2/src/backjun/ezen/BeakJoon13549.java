package backjun.ezen;

import java.util.*;

/**
 * 구현문제에 가까운거 같다
 * 
 * 우선순위큐를 활용한 dfs를 활용했다
 * */
public class BeakJoon13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] visit = new boolean[100000 * 3];

        //Queue<int[]> que = new LinkedList<>();
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] > o2[0] ? 1 : -1;
                }
                return o1[1] > o2[1] ? 1 : -1;
            }
        });

        que.add(new int[]{n, 0});
        visit[n] = true;

        int res = 0;

        while (que.isEmpty() == false) {
            int[] temp = que.poll();
            n = temp[0];
            int cnt = temp[1];
            //System.out.println(n + " " + cnt);

            if (n == k) {
                String a = "!";
                res = cnt;
                break;
            } else {
                if (n * 2 < k * 2 && visit[n * 2] == false) {
                    visit[n * 2] = true;
                    que.add(new int[]{n * 2, cnt});
                }
                if (n + 1 <= k && visit[n + 1] == false) {
                    visit[n + 1] = true;
                    que.add(new int[]{n + 1, cnt + 1});
                }
                if (n - 1 >= 0 && visit[n - 1] == false) {
                    visit[n - 1] = true;
                    que.add(new int[]{n - 1, cnt + 1});
                }

            }
        }

        System.out.println(res);
    }
}




