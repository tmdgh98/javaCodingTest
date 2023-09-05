package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(br.readLine());

        int result = 0;

        int a;
        while(st.hasMoreTokens()){
            a = Integer.parseInt(st.nextToken());
            if(target == a){
                result++;
            }
        }

        System.out.println(result);
    }
}
