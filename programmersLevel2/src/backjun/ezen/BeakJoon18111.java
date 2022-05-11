package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 신나고 재미있는 구현문제
 * 조건을 꼼꼼히 좀 보자.....
 * <p>
 * 놓친것들
 * 1. 땅을 먼저 파야 판블록을 사용할수있는데 블록부터 먼저사용해서 틀림
 * 2. 블록사용하면서 재고 안떰
 * 3. 시간이 같을시에는 높이가 높은걸로 라는 조건놓침
 */

public class BeakJoon18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //int[][] arr = new int[n][m];
        int[] arr = new int[n * m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                //arr[i][j] = Integer.parseInt(st.nextToken());
                arr[m * i + j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[n * m - 1];

        int resTime = 0;
        int resHeight = 0;
        for (int target = min; target <= max; target++) {
            int time = 0;
            int invn = b;
            for (int i = n * m - 1; i >= 0; i--) {
                int gap;

                if (arr[i] < target) {
                    gap = target - arr[i];
                    if (invn < gap) {
                        time = -1;
                        break;
                    }
                    invn -= gap;
                    time += gap;
                } else if (arr[i] > target) {
                    gap = arr[i] - target;
                    invn += gap;
                    time += gap * 2;
                }
            }
            if (time == -1) {
                continue;
            }

            if (resTime == 0) {
                resTime = time;
                resHeight = target;
            } else {
                if (resTime > time || (resTime == time && resHeight < target)) {
                    resTime = time;
                    resHeight = target;
                }
            }
        }

        System.out.println(resTime + " " + resHeight);


    }
}