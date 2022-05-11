package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동적(dp)으로 푸는 문제라는데
 * 점화식을 못찾아서 탐욕으로 풀었다....
 *
 * 당연히 탐욕으로했더니 시간초과가 떠서
 * 몇번의 수정끝에 정답판정은 받았다
 *
 * 재귀함수를 활용해서 전체탐색을했으며 시간초과가 떠서
 *
 * 1. 제곱근을 구해서 제곱근부터 구했으나 그래도 시간초과가 떠서
 *
 * 2. 한번이라도 탐색했던 숫자는 배열에 담아두고 바로 꺼내쓰는 형식으로 시간을 줄였다
 *
 * 근데 그시간에 점화식을 찾았으면 찾을수있지 않았을까...?
 * */

public class BeakJoon17626 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        int count = fnFind(n);

        System.out.println(count);

    }

    private static int fnFind(int n) {

        int s = (int) Math.floor(Math.sqrt(n));
        if(arr[n]!=0){
            return arr[n];
        }

        int res = 9999999;
        while (s > 0) {
            int cut = n - (s * s);

            if (s == 1) {
                res = Math.min( n, res );
                break;
            } else if (cut == 0) {
                res = 1;
                break;
            } else {
               res = Math.min( fnFind(cut)+1, res );
            }

            s--;
        }

        arr[n] = res;
        return res;
    }
}
