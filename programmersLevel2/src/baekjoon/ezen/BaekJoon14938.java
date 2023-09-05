package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon14938 {
    static class Node {
        int index;
        int cost;

        Node(int index, int cost) {
            this.cost = cost;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //지역수
        int m = Integer.parseInt(st.nextToken()); //수색범위
        int r = Integer.parseInt(st.nextToken()); //길의개수

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            item[i + 1] = Integer.parseInt(st.nextToken());
        }

        int a, b, l;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); //지역번호 a
            b = Integer.parseInt(st.nextToken()); //지역번호 b
            l = Integer.parseInt(st.nextToken()); //길의 길이

            graph.get(a).add(new Node(b, l));
            graph.get(b).add(new Node(a, l));
        }

        int[] distinct;
        boolean[] visit;
        int res = 0;
        int tempRes;

        int startIndex, index, minDistinct, nextIndex;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            distinct = new int[n + 1];
            visit = new boolean[n + 1];
            Arrays.fill(distinct, Integer.MAX_VALUE);

            startIndex = i + 1;
            distinct[startIndex] = 0;
            visit[startIndex] = true;

            que.add(startIndex);
            while (que.isEmpty() == false) {
                index = que.poll();
                for (Node node : graph.get(index)) {
                    distinct[node.index] = Math.min(distinct[node.index], distinct[index] + node.cost);
                }

                minDistinct = Integer.MAX_VALUE;
                nextIndex = 0;
                for (int j = 0; j < n + 1; j++) {
                    if (visit[j] == false && distinct[j] < minDistinct) {
                        minDistinct = distinct[j];
                        nextIndex = j;
                    }
                }

                if(minDistinct != Integer.MAX_VALUE){
                    que.add(nextIndex);
                    visit[nextIndex] = true;
                }
            }

            tempRes = 0;
            for (int j = 0; j < n+1; j++) {
                if(distinct[j] <= m){
                    tempRes += item[j];
                }
            }

            res = Math.max(res,tempRes);
        }


        System.out.println(res);
    }

}
