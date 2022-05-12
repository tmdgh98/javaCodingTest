package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* 수학구현문제
 * 최대공약수, 최소공배수활용
 * 최대공약수 * 최소공배수 = a*b
* */
public class BeakJoon6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int mainNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < mainNum; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //최대공약수
            int maxCom = fnMaxCom(n, m);
            //최소공배수 == 마지막해
            int lastYear = n * m / maxCom;

            int year = -1;
            while (true) {
                if(x > lastYear || y > lastYear){
                    break;
                }

                if (x == y) {
                    year = x;
                    break;
                } else if (x > y) {
                    y += m;
                } else {
                    x += n;
                }
            }

            sb.append(year + "\n");
        }

        System.out.println(sb);
    }

    private static int fnMaxCom(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (a % b == 0) {
            return b;
        } else {
            return fnMaxCom(b, a % b);
        }
    }
}
