package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon21736 {

    private static class Vo {
        int x;
        int y;

        Vo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];

        String row;

        Vo vo = null;
        for (int i = 0; i < n; i++) {
            row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == 'I') {
                    vo = new Vo(i, j);
                }
            }
        }

        boolean[][] visit = new boolean[n][m];
        int[] xs = {0, 0, 1, -1};
        int[] ys = {1, -1, 0, 0};
        Queue<Vo> que = new LinkedList<>();
        que.add(vo);
        visit[vo.x][vo.y] = true;

        int res = 0;
        while (que.isEmpty() == false) {
            vo = que.poll();
            if (map[vo.x][vo.y] == 'P') {
                res++;
            }

            for (int i = 0; i < 4; i++) {
                if (-1 < vo.x + xs[i] && vo.x + xs[i] < n && -1 < vo.y + ys[i] && vo.y + ys[i] < m) {
                    if (map[vo.x + xs[i]][vo.y + ys[i]] != 'X') {
                        if (visit[vo.x + xs[i]][vo.y + ys[i]] == false) {
                            visit[vo.x + xs[i]][vo.y + ys[i]] = true;
                            que.add(new Vo(vo.x + xs[i], vo.y + ys[i]));
                        }
                    }
                }
            }
        }

        System.out.println(res == 0 ? "TT" : res);
    }


}
