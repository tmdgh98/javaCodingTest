package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * hash구현문제
 * int long 타입을 주의하자 어렵.....
 */

public class BeakJoon15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char[] charArr = str.toCharArray();

        long sum = 0;
        long r = 31;
        long m = 1234567891;
        for (int i = 0; i < l; i++) {
            int a = charArr[i] - 'a' + 1;
            long resR = 1;
            for (int j = 0; j < i; j++) {
                resR = resR * r % m;
            }
            sum += a * resR % m;

            sum = sum % m;
        }

        System.out.println(sum);
    }
}