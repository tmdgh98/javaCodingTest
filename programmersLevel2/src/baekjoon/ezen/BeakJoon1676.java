package baekjoon.ezen;

import java.util.Scanner;

/**
 * 그냥 수학적으로 풀었다...
 *
 * 언젠가 기회되면...... 코딩으로 푸는법도 생각해봐야지
 * */

public class BeakJoon1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;
        sum += n / 5;
        sum += n / 25;
        sum += n / 125;

        System.out.println(sum);
    }
}
