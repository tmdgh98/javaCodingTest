package backjun.ezen;

import java.io.IOException;
import java.util.Scanner;

public class Beakjoon1987 {

    static boolean[][] visit;
    static boolean[] alpha;

    static int[] xs = {1, -1, 0, 0};
    static int[] ys = {0, 0, 1, -1};

    static int r;
    static int c;

    static char[][] arr;

    static int res = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        visit = new boolean[r][c];
        alpha = new boolean[26];

        arr = new char[r][c];
        String str;
        for (int i = 0; i < r; i++) {
            str = sc.next();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.println(res);
    }

    private static void dfs(int x, int y, int d) {
        visit[x][y] = true;
        alpha[arr[x][y] - 'A'] = true;
        d++;

        res = Math.max(d, res);

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + xs[i];
            ny = y + ys[i];

            if (-1 < nx && nx < r && -1 < ny && ny < c) {
                if (visit[nx][ny] == false) {
                    if (alpha[arr[nx][ny] - 'A'] == false) {
                        dfs(nx, ny, d);
                    }
                }
            }
        }

        visit[x][y] = false;
        alpha[arr[x][y] - 'A'] = false;
    }


}
