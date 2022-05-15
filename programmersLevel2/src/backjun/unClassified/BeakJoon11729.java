package src.backjun.unClassified;

import java.util.Scanner;

/**
 * 하노이의탑
 * 
 * 규칙만 찾아내면 
 * 재귀를 활용한 코드자체는 간단한 문제
 * 
 * 근데 규칙찾기가 힘듬
 * */
public class BeakJoon11729 {
    static StringBuilder sb = new StringBuilder();
    static int[] location;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        location = new int[n+1];

        for (int i = 0; i < location.length; i++) {
            location[i] = 1;
        }

        fnMove(n,3);

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void fnMove(int n, int i) {
        if(n <= 0){
            return;
        }

        //보내기
        fnMove(n-1,6-i-location[n-1]);

        //옮기기
        sb.append(location[n] + " " + i + "\n");
        location[n] = i;
        cnt++;

        //가져오기
        fnMove(n-1,i);
    }
}
