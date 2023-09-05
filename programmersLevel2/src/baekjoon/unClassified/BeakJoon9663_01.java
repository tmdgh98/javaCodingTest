package src.backjun.unClassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 처음에 풀었던 방법
 * 체스판을 깊이마다 따로 관리하는 방법 그래서 3차원배열을 사용했다
 *
 * 메모리 초과문제가 발생해서 이짓저짓다해봤는데 결과는
 * xy, nx, ny 를 static으로 변경하니까 해결됐다....
 * 이유는 잘모르겠다
 * */
public class BeakJoon9663_01 {

    static int n;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n][n];

        int cnt = fnFind(0);

        System.out.println(cnt);
    }

    private static int fnFind(int cnt) {
        int res = 0;

        for (int j = 0; j < n; j++) {
            if (visit[cnt][cnt][j] == false) {
                if (cnt + 1 == n) {
                    res++;
                    continue;
                }
                //visit[cnt+1] = fnCapy(visit[cnt]);
                fnCheck(cnt + 1, cnt, j);
                res += fnFind(cnt + 1);

            }
        }

        return res;
    }
    static int[][] xy = {{1, 1}, {1, 0}, {1, -1}};
    static int nx;
    static int ny;
    private static void fnCheck(int cnt, int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[cnt][i][j] = visit[cnt - 1][i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                nx = x + (i * xy[j][0]);
                ny = y + (i * xy[j][1]);

                if (n > nx && nx > -1 && n > ny && ny > -1)
                    visit[cnt][nx][ny] = true;
            }
        }
    }
}
