package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * dfs 응용문제
 * 같은 최단거리에 위치한것들중 우선순위를 정하는게 문제였음
 *
 * 나는 같은거리에 있는것들을 리스트로 다저장해둔 후
 * 정렬해서 해결함
 * 
 * */

public class BeakJoon16236 {
    static int[][] sea;
    static int x = 0;
    static int y = 0;
    static int size = 2;
    static int stack = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        sea = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 9) {
                    x = i;
                    y = j;
                    sea[i][j] = 0;
                } else {
                    sea[i][j] = temp;
                }
            }
        }

        int count = 0;
        while (true) {
            int temp = fnEat();
            count += temp;
            if (temp == 0) {
                break;
            }
        }

        System.out.println(count);
    }

    private static int fnEat() {
        boolean[][] visit = new boolean[sea.length][sea.length];
        Queue<int[]> que = new LinkedList<>();

        int cnt = 0;
        int checkMate = -1;
        List<int[]> cntList = new ArrayList<>();
        visit[x][y] = true;
        que.add(new int[]{x, y, cnt});

        loop:
        while (que.isEmpty() == false) {
            int[] queItem = que.poll();

            int[][] next = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

            for (int i = 0; i < 4; i++) {
                int nx = queItem[0] + next[i][0];
                int ny = queItem[1] + next[i][1];
                cnt = queItem[2];

                if (sea.length > nx && nx > -1 && sea.length > ny && ny > -1) {
                    int target = sea[nx][ny];
                    if (target > size) {
                        continue;
                    }
                    if (target != size && target != 0) {
                        if (checkMate == -1) {
                            checkMate = cnt;
                        }
                        if (checkMate == cnt) {
                            cntList.add(new int[]{nx, ny, cnt});
                        }
                        if (checkMate < cnt) {
                            //return cnt;
                            break loop;
                        }
                    }

                    if (visit[nx][ny] == true) {
                        continue;
                    }
                    visit[nx][ny] = true;
                    que.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        if (checkMate == -1) {
            return 0;
        }

        Collections.sort(cntList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] > o2[1] ? 1 : -1;
                }
                return o1[0] > o2[0] ? 1 : -1;
            }
        });

        x = cntList.get(0)[0];
        y = cntList.get(0)[1];
        sea[x][y] = 0;
        stack++;
        if (stack == size) {
            size++;
            stack = 0;
        }
        return cntList.get(0)[2] + 1;
    }
}
