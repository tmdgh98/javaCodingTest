package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 맵구현문제
 *
 * Map객체를 사용해서 바로풀긴했는데 hashMap을 직접구현해야되는 문제였을까...?
 * */

public class BeakJoon17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String ps = st.nextToken();
            map.put(key,ps);
        }

        for (int i = 0; i < m; i++) {
            String key = br.readLine();
            String ps = map.get(key);
            sb.append(ps + "\n");
        }

        System.out.println(sb);
    }
}
