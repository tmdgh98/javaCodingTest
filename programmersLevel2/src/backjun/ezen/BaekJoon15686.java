package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon15686 {

    static int n; //도시 row,column
    static int m; //치킨집최대숫자
    static int[][] city; // 도시 배열
    static int chickenCount = 0; //치킨집개수
    static int closeCount; //폐업할 치킨집숫자
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        city = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) {
                    chickenCount++;
                }
            }
        }

        fnChickenClose(0,0);

        System.out.println(res);
    }

    private static void fnChickenClose(int depth, int start) {
        if ((chickenCount - depth) == m) {
            fnMinChickenLen();
            return;
        }

        for (int i = start; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (city[i][j] == 2) {
                    city[i][j] = 0;
                    fnChickenClose(depth + 1, i);
                    city[i][j] = 2;
                }
            }
        }

    }

    private static void fnMinChickenLen() {
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (city[i][j] == 1) {
                    len = len + fnChickenLen(i, j);
                }
            }
        }

        res = Math.min(res, len);
    }

    private static int fnChickenLen(int x, int y) {
        int len = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (city[i][j] == 2) {
                    temp = 0;
                    if (x > i) {
                        temp += x - i;
                    } else {
                        temp += i - x;
                    }

                    if (y > j) {
                        temp += y - j;
                    } else {
                        temp += j - y;
                    }
                    len = Math.min(len,temp);
                }
            }
        }
        return len;
    }

//    private static int fnChickenLen(int i, int j) {
//        int len = 0;
//        int[] temp;
//        Queue<int[]> que = new LinkedList<>();
//        que.add(new int[]{i, j, 0});
//
//        int x, y, d;
//        while (que.isEmpty() == false) {
//            temp = que.poll();
//            d = temp[2];
//            for (int k = 0; k < 4; k++) {
//                x = dx[k] + temp[0];
//                y = dy[k] + temp[1];
//
//                if (-1 < x && x < n && -1 < y && y < n) {
//                    if (city[x][y] == 2) {
//                        return d + 1;
//                    } else {
//                        que.add(new int[]{x, y, d + 1});
//                    }
//                }
//            }
//        }
//
//        return len;
//    }

}
