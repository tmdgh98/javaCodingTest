package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //전체사람숫자
        int m = Integer.parseInt(st.nextToken()); //파티숫자

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        int arr[] = new int[n + 1];
        boolean trueArr[] = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); //진실을 아는 사람 숫자
        int h; //사람번호
        while (st.hasMoreTokens()) {
            h = Integer.parseInt(st.nextToken());
            trueArr[h] = true;
        }

        int partyNum; //파티당 사람숫자
        int partyArr[][] = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            partyNum = Integer.parseInt(st.nextToken());

            partyArr[i] = new int[partyNum];

            for (int j = 0; j < partyNum; j++) {
                partyArr[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < partyNum; j++) {
                for (int k = 0; k < partyNum; k++) {
                    graph.get(partyArr[i][j]).add(partyArr[i][k]);
                }
            }
        }


        Queue<Integer> que = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (trueArr[i + 1]) {
                que.add(i + 1);
            }
        }

        int a;
        List<Integer> list;
        while (que.isEmpty() == false) {
            a = que.poll();

            list = graph.get(a);

            if (trueArr[a]) {
                for (int i : list) {
                    if (trueArr[i] == false) {
                        trueArr[i] = true;
                        que.add(i);
                    }
                }
            }
        }


        int res = 0;
        boolean resBoo;
        for (int i = 0; i < m; i++) {
            resBoo = true;
            for (int j = 0; j < partyArr[i].length; j++) {
                if (trueArr[partyArr[i][j]]) {
                    //파티에 거짓말이있음
                    resBoo = false;
                    break;
                }
            }

            if (resBoo) {
                res++;
            }
        }

        System.out.println(res);

    }
}
