package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 요세푸스문제 
 * 리스트랑 배열좀 그만쓰고 큐활용을 해보자
 * */
public class BaekJoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for (int i=1; i<=n; i++){
            que.add(i);
        }

        /* 큐를 활용한 요세푸스 문제 해결*/
        while(que.isEmpty() == false){
            for(int i=1; i<=m; i++){
                int pollInt = que.poll();
                if(i != m){
                    que.add(pollInt);
                }else{
                    //sb.append(pollInt+"\n");
                    result.add(pollInt);
                }
            }
        }


        /* 정답출력부분 쓸모없음 */
        for(int i=0; i<n; i++){
            if(i == 0){
                sb.append("<");
            }

            sb.append(result.get(i));

            if(i != n-1){
                sb.append(", ");
            }else{
                sb.append(">");
            }
        }

        System.out.println(sb);
    }
}

