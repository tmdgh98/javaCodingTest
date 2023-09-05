package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이분탐색 하한값 문제
 *
 * 받은변수가 int타입에 담기는지 확인할것
 * 담긴다하더라도 연산하게될시 넘치지않는지 확인할것
 *
 * */

public class BeakJoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = fnFindHeight(arr, m);

        System.out.println(res);

    }

    private static int fnFindHeight(int[] arr, int m) {
        int start = 0;
        int end = 0;

        for (int item : arr) {
            end = Math.max(end, item);
        }

        while (start <= end) {
            int mid = (end - start) / 2 + start;

            if (fnCheck(arr, m, mid) == true) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start-1;
    }

    private static boolean fnCheck(int[] arr, int m, int target) {
        long length = 0;

        for (int i = 0; i < arr.length; i++) {
            int cut = arr[i] - target;
            length += cut > 0 ? cut : 0;
        }

        return length >= m ? true : false;
    }
}
