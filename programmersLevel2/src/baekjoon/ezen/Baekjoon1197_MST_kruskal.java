package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1197_MST_kruskal {

    private static class Vo implements Comparable<Vo> {
        int v; //출발정점
        int w; //도착정점
        int d; //간선거리
        
        Vo(int v, int w, int d){
            this.v = v;
            this.w = w;
            this.d = d;
        }

        @Override
        public int compareTo(Vo o) {
            return d - o.d;
        }
    }

    static int[] vs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); //정점
        int e = Integer.parseInt(st.nextToken()); //간선

        vs = new int[v+1]; //정점집합
        for (int i = 0; i < vs.length; i++) {
            vs[i] = i;
        }
        
        List<Vo> graph = new ArrayList<>();
        int a,b,c;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); //출발정점
            b = Integer.parseInt(st.nextToken()); //도착정점
            c = Integer.parseInt(st.nextToken()); //간선거리

            graph.add(new Vo(a,b,c));
        }

        Collections.sort(graph);

        long res = 0;

        for (int i = 0; i < e; i++) {
            Vo vo = graph.get(i);

            if(find(vo.v) == find(vo.w)){
                continue;
            }

            res += vo.d;

            union(vo.v, vo.w);
        }

        System.out.println(res);
    }

    private static int find(int v) {
        if(vs[v] == v){
            return v;
        } else {
            return find(vs[v]);
        }
    }

    static void union(int A, int B){
        int a = find(A);
        int b = find(B);

        if(a != b)
            vs[b] = a;
    }

}
