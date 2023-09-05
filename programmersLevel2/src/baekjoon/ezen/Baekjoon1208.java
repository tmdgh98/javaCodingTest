package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1208 {

    private static List<Integer> llist = new ArrayList<>();
    private static List<Integer> rlist = new ArrayList<>();
    private static int[] arr;

    /*
    1208 부분수열의 합2
    https://lotuslee.tistory.com/84
    이분탐색, 투포인터검색
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        fnSet(0, n / 2, 0, llist);
        fnSet(n / 2, n, 0, rlist);

        long cnt = fnTwoPoint(s);
        cnt = s == 0 ? cnt - 1 : cnt;

        System.out.println(cnt);
    }

    private static long fnTwoPoint(int target) {
        long res = 0;

        Collections.sort(llist);
        Collections.sort(rlist, Comparator.reverseOrder());

        int li = 0;
        int ri = 0;

        int sum;
        long rRes, lRes, lValue, rValue;
        while (li < llist.size() && ri < rlist.size()) {
            sum = llist.get(li) + rlist.get(ri);
            if (sum == target) {
                rValue = rlist.get(ri);
                rRes = 0;
                while (ri < rlist.size() && rlist.get(ri) == rValue) {
                    rRes++;
                    ri++;
                }

                lValue = llist.get(li);
                lRes = 0;
                while (li < llist.size() && llist.get(li) == lValue) {
                    lRes++;
                    li++;
                }

                res += rRes * lRes;

            } else if (sum > target) {
                ri++;
            } else {
                li++;
            }
        }

        return res;
    }

    private static int fnListIndexPlus(int i, List<Integer> list) {
        int res = i;

        while (res < list.size() && list.get(i) == list.get(res)) {
            res++;
        }

        return res;
    }

    private static void fnSet(int s, int e, int t, List<Integer> list) {
        if (s == e) {
            list.add(t);
            return;
        }
        fnSet(s + 1, e, arr[s] + t, list);
        fnSet(s + 1, e, t, list);
    }

}
