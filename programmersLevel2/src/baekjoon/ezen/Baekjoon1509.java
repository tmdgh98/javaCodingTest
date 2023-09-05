package baekjoon.ezen;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1509 {

    private static String str;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        str = sc.next();

        int[] cnt = new int[str.length()];
        Arrays.fill(cnt, 2600);

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (fnP(j, i)) {
                    if (j == 0) {
                        cnt[i] = Math.min(cnt[i], 1);
                    } else {
                        cnt[i] = Math.min(cnt[i], cnt[j - 1] + 1);
                    }
                }
            }
        }

        System.out.println(cnt[str.length() - 1]);
    }

    private static boolean fnP(int j, int i) {
        boolean res = true;
        int s = j;
        int e = i;
        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                res = false;
                break;
            }
        }
        return res;
    }

}
