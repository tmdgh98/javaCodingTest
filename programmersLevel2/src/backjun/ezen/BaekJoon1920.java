package backjun.ezen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 평범한 이분탐색문제
 * */
public class BaekJoon1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt( st.nextToken() );
        }

        int m = Integer.parseInt(br.readLine());
        int b[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt( st.nextToken() );
        }

        int target;
        Arrays.sort(a);

        for(int i=0; i<m; i++){
            target = b[i];

            String result = fnFindA(target,a);

            sb.append(result);

            if(i!=m-1){
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static String fnFindA(int target, int[] array) {
        String result = "0";

        int start = 0;
        int end = array.length-1;
        int index = (end - start) / 2 + start;

        while(start <= end){
            int arrayInt = array[index];
            if( arrayInt == target){
                return "1";
            }else if(arrayInt < target){
                start = index+1;
            }else{
                end = index-1;
            }
            index = (end - start) / 2 + start;
        }

        return result;
    }
}
