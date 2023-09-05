package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * deque 구현문제 같은데 나도 잘모르겠음
 * 일부로 deque 객체안쓰고 구현해봄
 *
 * 틀린이유
 * 1. list.toString 안쓰고 직접 문자열만드니까 시간초과됨
 * 2. R로 순서 반전시킨거 출력결과에 반영안함
 * 3. list.toString 쓰면 [1, 2, 3] 이런식으로 ,마다 ' '가 반영되는데 이거 오답처리됨
* */

public class BeakJoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String cmdStr = br.readLine();
            //String[] cmdArr = cmdStr.split("");
            int length = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            arrStr = arrStr.replace("[", "");
            arrStr = arrStr.replace("]", "");
            String[] arr = arrStr.split(",");

            int start = 0;
            int end = length;
            int status = 0; //0 : 정방향, 1 : 역방향
            String res = null;

/*            for (String cmd : cmdArr) {
                if(cmd.equals("R")){
                    status = status == 1 ? 0 : 1;
                }else if(cmd.equals("D")){
                    if(start == end){
                        res = "error";
                        break;
                    }

                    if(status == 0){
                        start++;
                    }else{
                        end--;
                    }
                }
            }*/
            for (char cmd : cmdStr.toCharArray()) {
                if (cmd == 'R') {
                    status = status == 1 ? 0 : 1;
                } else if (cmd == 'D') {
                    if (start == end) {
                        res = "error";
                        break;
                    }

                    if (status == 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }


            List<String> resArr = new ArrayList<>();
            if (res == null) {
                /*res = "[";
                for (int j = start; j < end; j++) {
                    res += arr[j];

                    res += j == end-1 ? "" : ",";
                }
                res += "]";*/

                for (int j = start; j < end; j++) {
                    resArr.add(arr[j]);
                }

                if(status == 1){
                    Collections.reverse(resArr);
                }
                res = resArr.toString().replace(" ","");
            }

            sb.append(res + "\n");
        }

        System.out.println(sb);
    }
}
