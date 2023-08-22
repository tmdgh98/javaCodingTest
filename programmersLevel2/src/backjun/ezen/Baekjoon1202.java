package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1202 {

    private static class Jewelry implements Comparable<Jewelry> {
        int m; //무게
        int v; //가치

        Jewelry(int m, int v){
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry o) {
            return m - o.m;
        }
    }

    private static PriorityQueue<Jewelry> que;
    private static List<Integer> bag;
    private static PriorityQueue<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //보석개수
        int k = Integer.parseInt(st.nextToken()); //가방개수

        que = new PriorityQueue<>();
        bag = new ArrayList<>();

        int m,v;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            que.offer(new Jewelry(m,v));
        }

        int b;
        for (int i = 0; i < k; i++) {
            b = Integer.parseInt(br.readLine());

            bag.add(b);
        }
        Collections.sort(bag);

        long res = 0;
        result = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            while (que.isEmpty() == false){
                if(que.peek().m > bag.get(i)){
                    break;
                }

                result.offer(que.poll().v);
            }

            if(result.isEmpty()){
                continue;
            }

            res += result.poll();
        }

        System.out.println(res);
    }

}
