package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
* 너비탐색(BFS)문제
 *
 * 방문횟수 최소값으로 조건걸필요없이 방문여부만 체크하고 최초로 100칸을 방문하는순간 종료하면 됐다
 * BFS 특성상최초방문이 최소방문횟수가 된다
 * 
 * 쓸데없이 탐색횟수만 길어짐
 * 
 * 최소방문횟수를 조건으로 거는건 다이나믹프로그래밍 알고리즘 사용할때
* */

public class BeakJoon16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        int[] countArr = new int[101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }

        Queue<int[]> que = new LinkedList<>();
        //위치, 주사위던진횟수
        int[] start = {1, 0};
        que.add(start);

        while (que.isEmpty() == false) {
            int[] arr = que.poll();
            int now = arr[0];
            int count = arr[1];
            //System.out.println(now + " " + count);
            if (now > 100) {
                continue;
            }
            if (map[now] != 0) {
                now = map[now];
            }
            if (countArr[now]!=0 && countArr[now] <= count) {
                continue;
            }else{
                countArr[now] = count;
                //System.out.println(now + " " + count);
            }

            for (int i = 0; i < 6; i++) {
                int[] tempArr = {i + now + 1, count+1};
                que.add(tempArr);
            }
        }

        System.out.println(countArr[100]);
    }
}
