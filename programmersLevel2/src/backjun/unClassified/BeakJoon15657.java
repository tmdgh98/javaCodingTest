package src.backjun.unClassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백트레킹문제 라는데 그냥 재귀함수로 품
 * 
 * 숫자와 문자의 정렬방법이 다르단걸 주의하자
 * */
public class BeakJoon15657 {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        fnGet(0,1, sb, null);

        System.out.println(sb);
    }

    private static String fnGet(int index, int depth, StringBuilder sb, String str) {

        for (int i = index; i < n; i++) {
            String res = str == null ? String.valueOf(arr[i]) : str + " " + arr[i];
            if(depth == m){
                sb.append(res + "\n");
            }else{
                fnGet(i,depth+1,sb,res);
            }
        }

        return "";
    }
}
