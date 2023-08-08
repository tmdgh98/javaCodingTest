package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon18110 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        int sum = 0;

        int[] arr = new int[c];

        for (int i = 0; i < c; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int ud = (int) Math.round(c * 0.15);

        for (int i = 0; i < c - 2 * ud; i++) {
            sum += arr[i + ud];
        }

        int res = (int) Math.round(sum / (c - 2 * ud * 1.0));

        System.out.println(res);
    }


}
