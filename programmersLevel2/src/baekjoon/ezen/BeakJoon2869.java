package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 즐거운 수학시간~
 * for돌리는거보다 수학적 수식짜는게 시간단축되는경우가 있다
 * */

public class BeakJoon2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

//        int now = 0;
//        int count = 0;
//        while(true){
//            count++;
//            now += a;
//
//            if(v<= now){
//                break;
//            }
//
//            now -= b;
//        }

        int target = v - a;
        int count;

        if(target > 0){
            count = target / (a-b) + 1 + (target % (a-b) != 0 ? 1 : 0);
        }else{
            count = 1;
        }

        System.out.println(count);
    }
}
