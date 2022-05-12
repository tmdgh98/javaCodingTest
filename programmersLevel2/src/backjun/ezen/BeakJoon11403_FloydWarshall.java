package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준11403 경로찾기문제
 * 플로이드와샬 알고리즘으로 푼경우
 * */

public class BeakJoon11403_FloydWarshall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
            }
        }

        for (int i = 0; i < n; i++) {
            int[] tempArr = arr[i];
            for (int j = 0; j < n; j++) {
                if(arr[j][i] == 1){
                    for (int k = 0; k < n; k++) {
                        if(arr[j][k] == 1){
                            continue;
                        }
                        if(tempArr[k] == 1){
                            arr[j][k] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(Arrays.toString(arr[i]).replace("[", "").replace("]", "").replace(",", "") + "\n");
        }

        System.out.println(sb);
    }
}
