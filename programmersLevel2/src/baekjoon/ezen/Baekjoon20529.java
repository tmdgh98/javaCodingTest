package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon20529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        List<String> list;
        for (int i = 0; i < t; i++) {
            list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());


            int resultDis = 20;
            if (n > 64) {
                resultDis = 0;
            } else {

                for (int j = 0; j < n; j++) {
                    list.add(st.nextToken());
                }

                Collections.sort(list);


                Loop:
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        for (int m = k + 1; m < n; m++) {
                            int dis = 0;
                            for (int l = 0; l < 4; l++) {
                                if (list.get(j).charAt(l) != list.get(k).charAt(l)) {
                                    dis++;
                                }
                                if (list.get(j).charAt(l) != list.get(m).charAt(l)) {
                                    dis++;
                                }
                                if (list.get(k).charAt(l) != list.get(m).charAt(l)) {
                                    dis++;
                                }
                            }
                            resultDis = Math.min(resultDis, dis);

                            if (resultDis == 0) {
                                break Loop;
                            }
                        }

                    }
                }

            }

            sb.append(resultDis);
            sb.append("\n");
        }

        System.out.println(sb);
    }


}
