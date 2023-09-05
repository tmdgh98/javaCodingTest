package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14940 {

    static class Vo {
        int x;
        int y;
        int distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int[][] distance = new int[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        Vo vo = new Vo();
        vo.x = x;
        vo.y = y;
        vo.distance = 0;
        visit[x][y] = true;

        Queue<Vo> que = new LinkedList<>();
        que.add(vo);

        int[] xs = {1, -1, 0, 0};
        int[] ys = {0, 0, 1, -1};

        while (que.isEmpty() == false) {
            vo = que.poll();

            if (arr[vo.x][vo.y] == 0) {
                distance[vo.x][vo.y] = 0;
                continue;
            }

            distance[vo.x][vo.y] = vo.distance;

            for (int i = 0; i < 4; i++) {
                if (0 <= vo.x + xs[i] && vo.x + xs[i] < n && 0 <= vo.y + ys[i] && vo.y + ys[i] < m) {
                    if (visit[vo.x + xs[i]][vo.y + ys[i]] == true) {
                        continue;
                    }
                    visit[vo.x + xs[i]][vo.y + ys[i]] = true;

                    Vo newVo = new Vo();
                    newVo.x = vo.x + xs[i];
                    newVo.y = vo.y + ys[i];
                    newVo.distance = vo.distance + 1;
                    que.add(newVo);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j] == false && arr[i][j] == 1) {
                    sb.append("-1");
                }else{
                    sb.append(distance[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


}
