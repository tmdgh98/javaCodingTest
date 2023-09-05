package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 구간합구하기 2차배열형태
 *
 * 내가 왜 이 점화식을 알고잇는진 모르겠는데 알고있어서 풀었음
 *
 * 합 = x,y + sum(x-1,y) + sum(x,y-1) - sum(x-1,y-1)
 * 구간합 = x1,y1 ~ x2,y2 = sum(x2,y2) - sum(x1-1,y2) - sum(x2,y1-1) + sum(x1-1,y1-1)
 * */

public class BeakJoon11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[][] sumArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = i - 1 >= 0 ? sumArr[i - 1][j] : 0;
                int b = j - 1 >= 0 ? sumArr[i][j - 1] : 0;
                int c = i - 1 >= 0 && j - 1 >= 0 ? sumArr[i - 1][j - 1] : 0;

                sumArr[i][j] = arr[i][j] + a + b - c;
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int a = x1 - 1 >= 0 ? sumArr[x1 - 1][y2] : 0;
            int b = y1 - 1 >= 0 ? sumArr[x2][y1 - 1] : 0;
            int c = x1 - 1 >= 0 && y1 - 1 >= 0 ? sumArr[x1 - 1][y1 - 1] : 0;

            sum = sumArr[x2][y2] - a - b + c;

            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
