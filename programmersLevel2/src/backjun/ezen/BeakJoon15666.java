package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 재귀 수열문제
 * */

public class BeakJoon15666 {
    static StringBuilder sb = new StringBuilder();
    static int n ;
    static int m;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        fnMakeSb("",0,1);

        System.out.println(sb);
    }

    private static void fnMakeSb(String str, int index, int depth) {
        int pre = -1;
        for (int i = index; i < n; i++) {
            if(pre == arr[i]){
                continue;
            }
            pre=arr[i];
            if(m == depth){
                sb.append(str+arr[i]+"\n");
                continue;
            }
            fnMakeSb(str+arr[i]+" ",i,depth+1);

        }
    }
}
