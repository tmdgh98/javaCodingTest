package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 해쉬맵을 활용한 경우의수(수학) 문제
 * 
 * 각각경우의수 +1 한걸 전부다 곱해서 -1하면 간단한데
 * 
 * ㅄ같이 새로운공식을 만들어서 품
 * */

public class BeakJoon9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            int res = 0;

            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String item = st.nextToken();
                String part = st.nextToken();

                map.put(part, (map.get(part) == null ? 0 : map.get(part)) + 1);
            }


            for (String key : map.keySet()) {
                int value = map.get(key);
                res = res*value + value + res;
            }

            sb.append(res + "\n");
        }

        System.out.println(sb);
    }
}
