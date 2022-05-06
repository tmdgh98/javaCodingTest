package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 직각삼각형문제 개쉬움 가치없음
 */
public class BaekJoon4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //세변의 길이
        int length[] = new int[3];
        int a, b, c;


        int i = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            length[0] = Integer.parseInt(st.nextToken());
            length[1] = Integer.parseInt(st.nextToken());
            length[2] = Integer.parseInt(st.nextToken());

            if(length[0] != 0 && length[1] != 0 && length[2] != 0){
                break;
            }

            if (i != 0) {
                sb.append("\n");
            }else{
                i++;
            }

            Arrays.sort(length);

            a = (int) Math.pow(length[0], 2);
            b = (int) Math.pow(length[1], 2);
            c = (int) Math.pow(length[2], 2);
            if ((a + b) == c) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
        }

        System.out.println(sb);
    }
}
