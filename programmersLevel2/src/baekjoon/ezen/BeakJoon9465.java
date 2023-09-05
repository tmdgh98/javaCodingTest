package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon9465 {
    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        while (tc > 0) {
            tc--;

            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = fnFindMax();
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static int fnFindMax() {
        int[][] sum = new int[2][n];

        int a = 0;
        int b = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (i > 0) {
                    b = sum[1-j][i-1];
                }
                if (i > 1) {
                    a = Math.max(sum[0][i - 2], sum[1][i - 2]);
                }
                sum[j][i] = Math.max(a,b) + arr[j][i];
                max = Math.max(max,sum[j][i]);
            }
        }

        return max;
    }
}
