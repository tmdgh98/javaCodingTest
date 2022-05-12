package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP문제
 * 
 * DP문제라는걸 알면 규칙찾기를 열심히해서 어캐하겠는데
 * 
 * DP문제라는걸 어캐 캐치하는지 모르겠다
 * */
public class BeakJoon11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int[] arr = new int[n+1];

        arr[1] = 1;
        if(n > 1) {
            arr[2] = 3;
        }

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2] * 2 % 10007;
        }

        System.out.println(arr[n] % 10007);
    }
}
