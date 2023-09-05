package baekjoon.ezen;

import java.util.Scanner;

/**
 * 다때려넣으면 되는 단순 브루트 포스 문제
 * */

public class BeakJoon2231 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;

        for (int i = 1; i < n; i++) {
            int target = i;
            int sum = i;

            while(target != 0){

                sum += target % 10;
                target = target / 10;
            }

            if(sum == n){
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
