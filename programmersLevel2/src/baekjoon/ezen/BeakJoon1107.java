package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 리모컨문제 푸는데 일주일은 걸린듯.. 너무고생함
 *
 * 괜히 뭐 해보겠다고 이런짓저런짓하지말고 그냥 다때려넣는거부터 해보자....
 * */
public class BeakJoon1107 {

    static boolean[] remocon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String targetStr = br.readLine();
        int target = Integer.parseInt(targetStr);
        int targetLen = targetStr.length();
        remocon = new boolean[10]; //false 정상 true 고장

        int res = Math.abs(target - 100);

        int n = Integer.parseInt(br.readLine());
        if (n == 10) {
            //모든버튼고장
            st = new StringTokenizer(br.readLine());
            System.out.println(res);
        } else if (n == 0) {
            //모든버튼사용가능
            res = Math.min(targetLen, res);
            System.out.println(res);
        } else {
            //일부버튼고장남
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                remocon[temp] = true;
            }

            int i = 0;
            boolean whileCk = true;
            while (whileCk) {
                int plus = target + i;
                int minus = target - i;

                if (fnCheck(plus)) {
                    res = Math.min(i + String.valueOf(plus).length(), res);
                    whileCk = false;
                }
                if (minus>-1 && fnCheck(minus)) {
                    res = Math.min(i + String.valueOf(minus).length(), res);
                    whileCk = false;
                }
                i++;
            }

            System.out.println(res);
        }
    }

    private static boolean fnCheck(int n) {
        String str = String.valueOf(n);
        for (char c : str.toCharArray()) {
            if (remocon[c - '0']) {
                return false;
            }
        }
        return true;
    }
}
