package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리 생성 문제
 * 
 * 맵을활용해서 트리만듬
 * */

public class BeakJoon11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] parent = new int[n + 1];
        Map<Integer, List> map = new HashMap<>();

        int a;
        int b;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (map.containsKey(a) == false) {
                map.put(a, new ArrayList<Integer>());
            }
            if (map.containsKey(b) == false) {
                map.put(b, new ArrayList<Integer>());
            }

            map.get(a).add(b);
            map.get(b).add(a);
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        int node;
        parent[1] = 1;
        while (que.isEmpty()==false){
            node = que.poll();

            List<Integer> list = map.get(node);

            for (Integer childNode : list) {
                if(parent[childNode] != 0){
                    continue;
                }

                parent[childNode] = node;
                que.add(childNode);
            }
        }

        for (int i = 2; i < n+1; i++) {
            sb.append(parent[i] + "\n");
        }

        System.out.println(sb);
    }
}
