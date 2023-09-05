package src.backjun.unClassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부르트포스 문제
 * 괜히 어렵게 접근했다가 시간날림
 * */

public class BeakJoon7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][2];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int[] tempArr = new int[2];
            tempArr[0] = Integer.parseInt(st.nextToken());
            tempArr[1] = Integer.parseInt(st.nextToken());

            arr[i] = tempArr;
        }

        for (int i=0; i<n; i++){
            int[] a = arr[i];
            int count = 1;
            for (int j = 0; j < n; j++) {
                int[] b = arr[j];
                if(i==j){
                    continue;
                }

                if(b[0] > a[0] && b[1] > a[1]){
                    count++;
                }
            }

            sb.append(count + " ");
        }

        System.out.println(sb);

    }
}
