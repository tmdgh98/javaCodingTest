package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9935 {

    static String str;
    static String explosiveStr;
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        explosiveStr = br.readLine();

        char e = explosiveStr.charAt(0);
        boolean equals;
        int len;
        int explosiveLen;
        for (int i = 0; i < str.length(); i++) {
            sb.append( str.charAt(i) );
            len = sb.length();
            explosiveLen = explosiveStr.length();
            if( explosiveLen <= len ){
                equals = true;

                for (int j = 0; j < explosiveStr.length() ; j++) {
                    if(explosiveStr.charAt(j) != sb.charAt(j + len - explosiveLen)){
                        equals = false;
                        break;
                    }
                }

                if(equals){
                    sb.delete(len-explosiveLen,len);
                }
            }
        }

        if(sb.length() == 0){
            sb.append("FRULA");
        }
        System.out.println(sb);

    }

}
