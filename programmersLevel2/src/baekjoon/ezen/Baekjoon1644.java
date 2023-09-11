package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1644 {

    /*
    1644 문제집
    소수찾기, 두 포인터 합계
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> sosu = new ArrayList<>();

        boolean boo;
        for (int i = 2; i <= n; i++) {
            boo = true;
            for (int j : sosu) {
                if (Math.sqrt(i) < j) {
                    break;
                }
                if (i % j == 0) {
                    boo = false;
                    break;
                }
            }

            if (boo) {
                sosu.add(i);
            }
        }

        int res = 0;

        int a = 0;
        int b = 0;
        int sum = 0;
        while (a < sosu.size()) {
            if (sum == n) {
                res++;
                sum -= sosu.get(a);
                a++;
            } else if (sum < n && b < sosu.size()) {
                sum += sosu.get(b);
                b++;
            } else {
                sum -= sosu.get(a);
                a++;
            }
        }

        System.out.println(res);
    }

}
