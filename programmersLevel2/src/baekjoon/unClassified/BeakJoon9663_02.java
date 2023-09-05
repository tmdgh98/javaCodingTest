package src.backjun.unClassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 처음에 풀었던 방법
 * 메모리를 줄이는 과정에서 체스판을 그때끄때 초기화 시키는방법 3차원->2차원으로 줄었고 메모리도 줄긴했으나 이게 해결방법은 아니였다
 *
 * 메모리 초과문제가 발생해서 이짓저짓다해봤는데 결과는
 * xy, nx, ny 를 static으로 변경하니까 해결됐다....
 * 이유는 잘모르겠다
 * */
public class BeakJoon9663_02 {

    static int n;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new int[n][n];

        int cnt = fnFind(0);

        System.out.println(cnt);
    }

    private static int fnFind(int x) {
        int res = 0;

        for (int j = 0; j < n; j++) {
            if (visit[x][j] == 0) {
                if (x + 1 == n) {
                    res++;
                    continue;
                }
                //visit[cnt+1] = fnCapy(visit[cnt]);
                fnCheck(x, j);
                res += fnFind(x + 1);
                fnUnCheck(x, j);
            }
        }

        return res;
    }
    static int[][] xy = {{1, 1}, {1, 0}, {1, -1}};
    static int nx;
    static int ny;
    private static void fnCheck(int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                nx = x + (i * xy[j][0]);
                ny = y + (i * xy[j][1]);

                if (n > nx && nx > -1 && n > ny && ny > -1)
                    visit[nx][ny]++;
            }
        }
    }

    private static void fnUnCheck(int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                nx = x + (i * xy[j][0]);
                ny = y + (i * xy[j][1]);

                if (n > nx && nx > -1 && n > ny && ny > -1)
                    visit[nx][ny]--;
            }
        }
    }
}
