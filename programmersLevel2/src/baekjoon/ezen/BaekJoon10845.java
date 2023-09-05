package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개단순한 큐 구현문제 의미없음
 * */

public class BaekJoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int que[] = new int[10000];

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                que[end] = Integer.parseInt(st.nextToken());
                end++;
            } else if (cmd.equals("size")) {
                sb.append(end - start +"\n" );
            } else if (cmd.equals("empty")) {
                if (end == start) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (end == start) {
                sb.append("-1\n");
            } else if(cmd.equals("pop")){
                sb.append(que[start]+"\n");
                start++;
            }else if(cmd.equals("front")){
                sb.append(que[start]+"\n");
            }else if(cmd.equals("back")){
                sb.append(que[end-1]+"\n");
            }else{
                System.out.println(cmd);
                System.out.println("이거나오면안됨");
            }
        }

        System.out.println(sb);
    }

}
