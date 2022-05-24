package src.backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리지름구하는문제
 *
 * 아무점에서 최대값노드찾기
 * 찾은노드에서 다시 최대값노드찾기
 * 두점이 지름노드 두점의길이 지름
 * */

public class BeakJoon1967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List> tree= new HashMap<>();
        for (int i = 1; i < n+1; i++) {
            tree.put(i,new ArrayList<int[]>());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a,b,c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            tree.get(a).add(new int[]{b,c});
            tree.get(b).add(new int[]{a,c});
        }

        int[] res = fnGetNode(1,tree,n);
        res = fnGetNode(res[0],tree,n);

        System.out.println(res[1]);
    }

    private static int[] fnGetNode(int start, Map<Integer, List> tree, int n) {
        int[] res = new int[] {start,0}; //노드, 거리

        int[] distance = new int[n+1];
        boolean[] visit = new boolean[n+1];

        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;
        int maxNode = 0;
        int maxDistance=0;

        while (que.isEmpty() == false){
            int parent = que.poll();
            List<int[]> temp = tree.get(parent);

            if(temp == null) continue;

            for (int[] item : temp) {
                int child = item[0];
                int value = item[1];

                if(visit[child]){
                    continue;
                }

                visit[child] = true;
                distance[child] = distance[parent] + value;
                que.add(child);

                if(maxDistance < distance[child]){
                    maxDistance = distance[child];
                    maxNode = child;
                }
            }
        }

        res[0] = maxNode;
        res[1] = maxDistance;

        return res;
    }
}
