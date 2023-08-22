package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1005 {

    private static int[] time;
    private static int[] totalTime;
    private static int[] in;

    private static class Node {
        int in;
        int out;

        Node(int i, int o) {
            this.in = i;
            this.out = o;
        }
    }

    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int n, k;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            time = new int[n + 1];
            totalTime = new int[n + 1];
            in = new int[n + 1];
            graph = new ArrayList<>();

            //건물셋팅
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n+1; j++) {
                time[j] = Integer.parseInt(st.nextToken());
                graph.add(new ArrayList<>());
            }
            graph.add(new ArrayList<>());

            //그래프 생성
            int inNode, outNode;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                inNode = Integer.parseInt(st.nextToken());
                outNode = Integer.parseInt(st.nextToken());

                graph.get(inNode).add(outNode);
                in[outNode]++;
            }

            int taget = Integer.parseInt(br.readLine());

            Queue<Integer> que = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (in[j+1] == 0) {
                    que.add(j+1);
                }
            }



            Loop:
            while (que.isEmpty() == false) {
                inNode = que.poll();

                for (int j = 0; j < graph.get(inNode).size(); j++) {
                    outNode = graph.get(inNode).get(j);

                    totalTime[outNode] = totalTime[outNode] == 0 ? time[inNode] + totalTime[inNode] : Math.max(time[inNode] + totalTime[inNode], totalTime[outNode]);

                    in[outNode]--;
                    if (in[outNode] == 0) {
                        if (outNode == taget) {
                            break Loop;
                        }
                        que.add(outNode);
                    }
                }
            }

            int res = totalTime[taget] + time[taget];

            sb.append(res);
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
