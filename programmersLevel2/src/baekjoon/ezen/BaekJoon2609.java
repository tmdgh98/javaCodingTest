package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수, 최소공배수
 * 유클리드호제법
 * 최대공약수 : 유클리드호제법
 * 최소공배수 : n * m / 최대공약수
 * */

public class BaekJoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = Math.max(n,m);
        int min = Math.min(n,m);

        int maxCommonDivisor = fnEuclidean(max,min);

        sb.append(maxCommonDivisor);
        sb.append("\n");
        sb.append(n * m / maxCommonDivisor);
        System.out.println(sb);
    }

    private static int fnEuclidean(int a,int b) {

        while(a % b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }
}
