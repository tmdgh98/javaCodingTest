package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 재귀를 활용한 별찍기문제
 *
 * 반복패턴문제는 항상그렇듯 시간이 문제였다
 *
 * 시간줄인방법
 * 1. fnMakeStar()를 필요한구간마다(위1아래2 3번) 재귀로 들어가는형태에서 한번만 들어가고 만들어둔걸 재활용함 -> 3n에서 n으로 감소
 * 2. 공백을 찍는걸 줄마다 for를 돌려 찍었으나 gap이라는 String변수에 담아두고 재활용함 -> 시간복잡도가 O(n2)에서 O(n)으로 감소
 * */

public class BeakJoon2448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] star = fnMakeStar(n);

        for (String s : star) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }

    private static String[] fnMakeStar(int size) {
        String[] star = new String[size];

        if (size == 3) {
            star[0] = "  *  ";
            star[1] = " * * ";
            star[2] = "*****";
        } else {
            int start = 0;
            int mid = size / 2;
            int end = size;
            String[] miniStar = fnMakeStar(size / 2);

            //위
            String gap = "";
            for (int i = 0; i < size / 2; i++) {
                gap += " ";
            }
            for (int i = start; i < mid; i++) {
                star[i] = gap;

                star[i] += miniStar[i - start];

                star[i] += gap;
            }

            //아래
            for (int i = mid; i < end; i++) {
                star[i] = "";
                star[i] += miniStar[i - mid];

                star[i] += " ";

                star[i] += miniStar[i - mid];
            }
        }

        return star;
    }
}
