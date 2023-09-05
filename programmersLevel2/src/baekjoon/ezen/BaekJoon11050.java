package baekjoon.ezen;

import java.util.Scanner;

/**
 * 이항계수1
 * 1단계라 그런지 통과되면 안되는데 통과되버림
 * 귀찮아서 그냥 더 안함
 *
 * 풀다보면 2단계만날거니까 그때 시간단축구현
 * */

public class BaekJoon11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = fnBinomialCoefficient(n,k);

        System.out.println(result);
    }

    private static int fnBinomialCoefficient(int n, int k) {
        if(k==0){
            return 1;
        }else if(n==k) {
            return 1;
        }

        int result = fnBinomialCoefficient(n-1,k-1) + fnBinomialCoefficient(n-1,k);
        return result;
    }
}
