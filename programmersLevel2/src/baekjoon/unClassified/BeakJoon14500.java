package src.backjun.unClassified;//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    public static int[][] paper;
//    public static int[][] visit;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        paper = new int[n][m];
//        int[][] count = new int[n][m];
//        visit = new int[n][m];
//        int max = 0;
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < m; j++) {
//                paper[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                visit = fnVisit();//new boolean[n][m];
//                max = Math.max(max, fnGetCount(i, j));
//            }
//        }
//
//        System.out.println(max);
//    }
//
//
//    private static int fnGetCount(int i, int j) {
//        int res = 0;
//
//        Stack<int[]> stack = new Stack<>();
//        int cnt = 1;
//        stack.add(new int[]{i, j, cnt, paper[i][j]});
//        visit[i][j] = cnt;
//
//        while (stack.isEmpty() == false) {
//            int[] arr = stack.pop();
//            int x = arr[0];
//            int y = arr[1];
//            int c = arr[2];
//            int sum = arr[3];
//
//            if(c == 4){
//                res = Math.max(res, sum);
//            }
//
//            int[] xs = {1, -1, 0, 0};
//            int[] ys = {0, 0, 1, -1};
//            int nx;
//            int ny;
//
//            for (int k = 0; k < 4; k++) {
//                nx = x + xs[k];
//                ny = y + ys[k];
//
//                if (fnCheak(nx, ny, cnt)) {
//                    stack.add(new int[] {nx,ny,c+1,sum+paper[nx][ny]});
//                }
//            }
//        }
//
//        return res;
//    }
//
//    private static boolean fnCheak(int i, int j, int cnt) {
//
//        if (i < 0 || j < 0) {
//            return false;
//        }
//        if (i > visit.length - 1) {
//            return false;
//        }
//        if (j > visit[i].length - 1) {
//            return false;
//        }
//        if (cnt > 3) {
//            return false;
//        }
//        if (visit[i][j] > 0) {
//            return false;
//        }
//
//        visit[i][j] = cnt + 2;
//
//        return true;
//    }
//
//    private static int[][] fnVisit() {
//        for (int i = 0; i < visit.length; i++) {
//            for (int j = 0; j < visit[i].length; j++) {
//                visit[i][j] = 0;
//            }
//        }
//        return visit;
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구현문제
 * bfs 너비탐색을 응용해서 풀긴했는데
 *
 * 중간중간 하드코딩이 워낙많아서 잘모르겠다...
 * 방문기록으로 하려다 케이스 한개가 해결이 안되고 시간문제도 해결이안되서
 *
 * 그냥 방문초기화 자체도 O(n2)시간을 잡아먹어서 방문배열을 없애버리고
 * 직전좌표만 피하는 방법으로 수정후 정답처리됐다.
 *
 * 특이케이스로 매개변수 -> 전역변수로 하면 시간이 줄어든다.
 *
 * */
public class BeakJoon14500 {

    public static int[][] paper;
    public static int[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        int[][] count = new int[n][m];
        visit = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //visit = fnVisit();//new boolean[n][m];
                max = Math.max(max, fnGetCount(i, j));
            }
        }

        System.out.println(max);
    }

    private static int[][] fnVisit() {
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[i].length; j++) {
                visit[i][j] = 0;
            }
        }
        return visit;
    }

    private static int fnGetCount(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i, j, 1, paper[i][j], i,j});
        visit[i][j] = 2;
        int res = 0;
        int[] xArr = {1, -1, 0, 0};
        int[] yArr = {0, 0, 1, -1};
        int one = 0;
        int two = 0;
        int three = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + xArr[k];
            int y = j + yArr[k];

            if (fnCheak(x, y, -1, -1, -1)) {
                if(i == 2 & j==2){
                    int tet = 1;
                }
                int temp = paper[x][y];
                if (temp > one) {
                    three = two;
                    two = one;
                    one = temp;
                } else if (temp > two) {
                    three = two;
                    two = temp;
                } else if (temp > three) {
                    three = temp;
                }
            }
        }
        res = paper[i][j] + one + two + three;

        while (que.isEmpty() == false) {
            int[] tempArr = que.poll();
            i = tempArr[0];
            j = tempArr[1];
            int cnt = tempArr[2];
            int sum = tempArr[3];
            int pi = tempArr[4];
            int pj= tempArr[5];
            if(cnt==4) {
                res = Math.max(res, sum);
            }

            int max = 0;
            for (int k = 0; k < 4; k++) {
                int x = i + xArr[k];
                int y = j + yArr[k];
                if (fnCheak(x, y, cnt, pi, pj)) {
                    //visit[x][y] = cnt;
                    que.add(new int[]{x, y, cnt + 1, sum + paper[x][y], i, j});
                }
            }
        }

        return res;
    }

    private static boolean fnCheak(int i, int j, int cnt, int pi, int pj) {

        if (i < 0 || j < 0) {
            return false;
        }
        if (i > visit.length - 1) {
            return false;
        }
        if (j > visit[i].length - 1) {
            return false;
        }
        if (cnt > 3) {
            return false;
        }
//        if(cnt ==3 && visit[i][j] >0){
//            return false;
//        }
        if( i == pi && j == pj){
            return false;
        }


//        if (visit[i][j] == cnt) {
//            return false;
//        }
//
//        visit[i][j] = cnt+2;

        return true;
    }
}
