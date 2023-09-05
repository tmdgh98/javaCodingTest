package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11444 {
    static int[][] initArr = {{1,1},{1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long n = Long.parseLong(br.readLine());

        long[][] res = fnFindRes(n);

        System.out.println(res[0][1]);
    }

    private static long[][] fnFindRes(long n) {

        if(n == 1){
            return new long[][] {{1,1},{1,0}};
        }

        long res[][] = fnFindRes(n/2);
        if(n%2 == 0){
            return fnMult(res,res);
        }else{
            return fnMult(fnMult(res,res),new long[][] {{1,1},{1,0}});
        }
    }

    private static long[][] fnMult(long[][] a, long[][] b) {
        long[][] res = new long[2][2];

        res[0][0] = ( a[0][0] * b[0][0] + a[0][1] * b[1][0] ) % 1000000007;
        res[0][1] = ( a[0][0] * b[0][1] + a[0][1] * b[1][1] ) % 1000000007;
        res[1][0] = ( a[1][0] * b[0][0] + a[1][1] * b[1][0] ) % 1000000007;
        res[1][1] = ( a[1][0] * b[0][1] + a[1][1] * b[1][1] ) % 1000000007;

        return res;
    }
}
