import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 웜홀 {
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int n, m, w;
        int s, e, t;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            //int[][] graph = new int[n + 1][n + 1];
            int[][] line = new int[m*2+w][3];
            int[] distance = new int[n + 1];
            boolean[] visit;
//            for (int j = 0; j <= n+1; j++) {
//                Arrays.fill(graph[j],inf);
//            }

            Arrays.fill(distance,inf);

            for (int j = 0; j < m*2; j++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());

                //graph[s].add(new int[]{e, t});
                //graph[e].add(new int[]{s, t});
                //graph[s][e] = t;
                //graph[e][s] = t;
                line[j] = new int[]{s,e,t};
                j++;
                line[j] = new int[]{e,s,t};
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken()) * -1;

                //graph[s].add(new int[]{e, t * -1});
                //graph[s][e] = t;
                line[m*2+j] = new int[]{s,e,t};
            }

            distance[1] = 0;
            boolean check = false;

            loop :
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m*2+w; k++) {
                    int[] temp = line[k];
                    s = temp[0];
                    e = temp[1];
                    t = temp[2];

                    if(distance[s] == inf){
                        continue;
                    }
                    if(distance[e] > distance[s]+t){
                        if(j == n-1){
                            check = true;
                            break loop;
                        }
                        distance[e] = distance[s]+t;
                    }
                }
            }

            if(check){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
