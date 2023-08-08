package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon17144 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r][c];
        List<int[]> air = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    air.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < t; i++) {
            arr = fnSpread(arr, air); //미세먼지확산
            fnOperation(arr, air); //공기청정기 작동
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != -1) {
                    res += arr[i][j];
                }
            }
        }

        System.out.println(res);
    }


    private static int[][] fnSpread(int[][] arr, List<int[]> airList) {
        int n = arr.length;
        int m = arr[0].length;
        int[] air = airList.get(0);
        int[] air2 = airList.get(1);

        int[][] tempArr = new int[n][m];
        tempArr[air[0]][air[1]] = -1;
        tempArr[air2[0]][air2[1]] = -1;

        int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int spreadValue;
        int spreadCnt;
        int x,y;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != -1 && arr[i][j] != 0){
                    spreadValue = arr[i][j] / 5;
                    spreadCnt = 0;
                    for (int[] ints : next) {
                        x = i + ints[0];
                        y = j + ints[1];
                        if((-1 < x && x < n && -1 < y && y < m)){
                            if(arr[x][y] != -1){
                                spreadCnt++;
                                tempArr[x][y] += spreadValue;
                            }
                        }
                    }
                    tempArr[i][j] += arr[i][j] - (spreadValue * spreadCnt);
                }
            }
        }

        return tempArr;
    }

    private static void fnOperation(int[][] arr, List<int[]> airList) {
        int[] air = airList.get(0);
        int[] air2 = airList.get(1);

        int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] next2 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        fnOperation2(arr,air,next, -1, air[0] + 1);
        fnOperation2(arr,air2,next2, air2[0] - 1, arr.length);
    }

    private static void fnOperation2(int[][] arr, int[] air, int[][] next, int start, int end) {
        int m = arr[0].length;
        int x = air[0];
        int y = air[1];
        int nextX;
        int nextY;
        for (int[] ints : next) {
            nextX = x + ints[0];
            nextY = y + ints[1];
            while (start < nextX && nextX < end && -1 < nextY && nextY < m) {
                if(arr[x][y] != -1){
                    arr[x][y] = arr[nextX][nextY] == -1 ? 0 : arr[nextX][nextY];
                }

                x = nextX;
                y = nextY;
                nextX = x + ints[0];
                nextY = y + ints[1];
            }
        }
    }
}
