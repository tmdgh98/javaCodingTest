package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeakJoon16953 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        long res = -1;
        Queue<long[]> que = new LinkedList<>();
        que.add(new long[]{a, 1});


        long[] arr;
        long t, c;
        long nextT1, nextT2;
        while (que.isEmpty() == false) {
            arr = que.poll();
            t = arr[0];
            c = arr[1];

            nextT1 = t * 2;
            nextT2 = t * 10 + 1;

            if (nextT1 == b || nextT2 == b) {
                res = c + 1;
                break;
            }

            if (nextT1 < b) {
                que.add(new long[]{nextT1, c + 1});
            }

            if (nextT2 < b) {
                que.add(new long[]{nextT2, c + 1});
            }
        }


        System.out.println(res);
    }
}
