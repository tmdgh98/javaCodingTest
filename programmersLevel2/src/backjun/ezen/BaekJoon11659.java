package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간합 문제
 * 위 내가 푼거 시간초과로 틀림.... 시간 n*m = O(n2)
 *
 * 아래 구간합알고리즘 보고푼문제
 * 시간 n+m = O(n)
 *
 * 구간합알고리즘
 * 미리 0부터 시작되는 모든구간별 합계를 구한다
 * 필요구간에 미리구한 합계를 빼기로 계산만한다
 * ex) 5~10구간 합계
 * 미리 0~4, 0~10구간합을 구해둔다
 * 0~10 - 0~4 = 5~10구간합계
 *
 * */
public class BaekJoon11659 {
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int res = 0;

            for (int j = s; j <= e; j++) {
                res += arr[j];
            }

            sb.append(res + "\n");
        }

        System.out.println(sb);
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int res = sum[e] - sum[s-1];

            sb.append(res + "\n");
        }

        System.out.println(sb);
    }
}
