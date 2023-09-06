package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1766 {

    /*
    1766 문제집
    우선순위큐, 위상정렬
    */

    static List<Queue<Integer>> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nodes = new int[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new PriorityQueue<>());
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            nodes[b]++;
        }

        Queue<Integer> que = new PriorityQueue<>();

        for (int i = 1; i < n + 1; i++) {
            if (nodes[i] == 0) que.add(i);
        }

        int node, node2;
        while (que.isEmpty() == false) {
           node = que.poll();
           sb.append(node);
           sb.append(" ");

           while(list.get(node).isEmpty() == false){
               node2 = list.get(node).poll();

               nodes[node2]--;

               if(nodes[node2] == 0){
                   que.add(node2);
               }
           }
        }

        System.out.println(sb);
    }

}
