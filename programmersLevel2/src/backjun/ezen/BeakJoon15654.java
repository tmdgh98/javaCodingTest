package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 재귀 수열문제
 * */

public class BeakJoon15654 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int depth = 1;
        fnMakeSb(depth, "");

        System.out.println(sb);

    }

    private static void fnMakeSb(int depth, String str) {
        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                if (depth == m) {
                    sb.append(str + arr[i] + "\n");
                    continue;
                }
                visit[i] = true;
                fnMakeSb(depth + 1, str + arr[i] + " ");
                visit[i] = false;
            }
        }
    }
}
