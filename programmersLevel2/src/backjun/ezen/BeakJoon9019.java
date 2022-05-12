package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS 너비탐색 시간제한 문제
 *
 * 메모리 초과로 삽질했으나 배열 얼마든지 new로 생성해도 됨
 * 시간 초과로 삽질했으나 substing이나 배열이나 별차이안남
 *
 * 너비탐색에서 시간줄이는법
 * 1. 작동여부와 별개로 방문지 체크는 꼭하자 2번방문시 생략 -> 안했을때 시간초과는커녕 메모리초과가 뜰수준이였음
 * 2. 방문여부 체크와 방문지 등록은 que에서 꺼내는 시점이 아니고 넣는시점에서 하자 -> 시간초과가 해결됐음
 * */
public class BeakJoon9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int mainNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < mainNum; i++) {
            String cmd = "";
            st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            int goal = Integer.parseInt(st.nextToken());
            String[] start = {now, cmd};

            Queue<String[]> que = new LinkedList<>();
            boolean[] visit = new boolean[10001];
            que.add(start);

            while (que.isEmpty() == false) {
                String[] tempArr = que.poll();
                now = tempArr[0];
                cmd = tempArr[1];
                int nowInt = Integer.parseInt(now);
                //if(cmd.equals("DDSDSRLD"))
                //System.out.println("now: "+now+" cmd: "+cmd+" goal: "+goal);

                if (goal == nowInt) {
                    //System.out.println(que.toString());
                    break;
                }

                //D
                //tempArr = new String[2];
                int nextInt = Integer.parseInt(now) * 2 % 10000;
                String next = Integer.toString(nextInt);
                String nextCmd = cmd + "D";
                if (visit[nextInt] == false) {
                    visit[nextInt] = true;
                    que.add(new String[]{next, nextCmd});
                }
                //s
                nowInt = nowInt == 0 ? 10000 : nowInt;
                nextInt = nowInt - 1;
                next = Integer.toString(nextInt);
                nextCmd = cmd + "S";
                if (visit[nextInt] == false) {
                    visit[nextInt] = true;
                    que.add(new String[]{next, nextCmd});
                }

                //L&R
                int nowSize = now.length();
                for (int j = 0; j < 4 - nowSize; j++) {
                    now = "0" + now;
                }
                //String[] nowArr = now.split("");
                //L
                //System.out.println(now + " " + cmd);
                //next = nowArr[1] + nowArr[2] + nowArr[3] + nowArr[0];
                next = now.substring(1) + now.substring(0, 1);
                nextInt = Integer.parseInt(next);
                nextCmd = cmd + "L";
                if (visit[nextInt] == false) {
                    visit[nextInt] = true;
                    que.add(new String[]{next, nextCmd});
                }
                //R
                //tempArr = new String[2];
                //next = nowArr[3] + nowArr[0] + nowArr[1] + nowArr[2];
                next = now.substring(3) + now.substring(0, 3);
                nextInt = Integer.parseInt(next);
                nextCmd = cmd + "R";
                if (visit[nextInt] == false) {
                    visit[nextInt] = true;
                    que.add(new String[]{next, nextCmd});
                }
            }

            sb.append(cmd + "\n");
        }

        System.out.println(sb);
    }
}
