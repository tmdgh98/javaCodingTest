package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 위주석 내가푼거 50점....
 * 
 * 아래 100점 컨닝한거.... ㅠㅠ
 * 
 * */

public class BeakJoon5525 {
//    public static void main(String[] args) throws IOException {
//
//        //Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//        String s = br.readLine();
//        char[] charArr = new char[n * 2 + 1];
//
//        for (int i = 0; i < n * 2 + 1; i++) {
//            charArr[i] = i % 2 == 0 ? 'I' : 'O';
//        }
//
//        String p = new String(charArr);
//
//        String temp = s;
//        int count = 0;
//        int index = temp.indexOf(p, 0);
//        while (index > 0) {
//            count++;
//            //temp = temp.substring(temp.indexOf(p)+1);
//            index = temp.indexOf(p, index+1);
//        }
//
//        System.out.println(count);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] charArr = s.toCharArray();

        int pattern = 0;
        int count = 0;

        for (int i = 1; i < m-1; i++) {
            if(charArr[i-1] == 'I' && charArr[i] == 'O'  && charArr[i+1] == 'I' ){
                pattern ++;
                i++;
                if(pattern == n){
                    pattern--;
                    count++;
                }
            }else{
                pattern = 0;
            }
        }

        System.out.println(count);
    }
}
