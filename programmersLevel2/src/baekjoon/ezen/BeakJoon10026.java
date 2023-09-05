package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 평범한 dfs문제에 조건하나 추가된 케이스
 * 
 * 나는 평범한 dfs와 조건이 추가된 dfs두개를 만들었는데
 * 
 * 그냥 dfs는 한개만 함수화시키고
 * 
 * arr을 원래버전과 조건으로 변경된 버전으로 돌렸으면 더 간단했을거같다
 * */

public class BeakJoon10026 {
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //R: 빨강, G: 초록, B파랑
        //케이스1 빨/초/파 다구분 케이스2 빨초/파 구분
        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            arr[i] = temp.split("");
        }

        int case1 = fnGetCountCase1();
        int case2 = fnGetCountCase2();

        System.out.println(case1 + " " + case2);
    }

    private static int fnGetCountCase2() {
        int length = arr.length;
        boolean[][] visit = new boolean[length][length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (visit[i][j] == true) {
                    continue;
                }
                visit[i][j] = true;
                count++;

                String target = arr[i][j];
                Queue<int[]> que = new LinkedList<>();
                que.add(new int[]{i, j});

                while (que.isEmpty() == false) {
                    int[] temp = que.poll();
                    int x = temp[0];
                    int y = temp[1];
                    int[] xs = {1, -1, 0, 0};
                    int[] ys = {0, 0, 1, -1};

                    for (int k = 0; k < 4; k++) {
                        int nx = x + xs[k];
                        int ny = y + ys[k];

                        if (length > nx && nx > -1 && length > ny && ny > -1 && visit[nx][ny] == false) {
                            if (arr[nx][ny].equals(target) || (arr[nx][ny].equals("G") && target.equals("R")) || (arr[nx][ny].equals("R") && target.equals("G"))) {
                                visit[nx][ny] = true;
                                que.add(new int[]{nx, ny});
                            }

                        }
                    }
                }
            }
        }

        return count;
    }

    private static int fnGetCountCase1() {
        int length = arr.length;
        boolean[][] visit = new boolean[length][length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (visit[i][j] == true) {
                    continue;
                }
                visit[i][j] = true;
                count++;

                String target = arr[i][j];
                Queue<int[]> que = new LinkedList<>();
                que.add(new int[]{i, j});

                while (que.isEmpty() == false) {
                    int[] temp = que.poll();
                    int x = temp[0];
                    int y = temp[1];
                    int[] xs = {1, -1, 0, 0};
                    int[] ys = {0, 0, 1, -1};

                    for (int k = 0; k < 4; k++) {
                        int nx = x + xs[k];
                        int ny = y + ys[k];

                        if (length > nx && nx > -1 && length > ny && ny > -1 && visit[nx][ny] == false && arr[nx][ny].equals(target)) {
                            visit[nx][ny] = true;
                            que.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return count;
    }
}
