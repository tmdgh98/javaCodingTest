package backjun.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 상한, 하한찾는 이분검색 문제
 * 그냥 상한,하한만 구하면 풀리는데
 * 
 * 검색후 상한,하한 찾는 바보짓함
 *
 * 아니다 상한,하한을 떠나서 값이 있는지를 알아야 되서 바보짓까진 아닌거같다
 * 비효율적인짓
 * */

public class BaekJoon10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int array[] = new int[n];
        st = new StringTokenizer(br.readLine());
/*        for(int i : array){
            i = Integer.parseInt(st.nextToken());
        }*/
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(array);

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int result = fnFindNumber(array, target);

            sb.append(result + " ");
        }

        System.out.println(sb);
    }

    private static int fnFindNumber(int[] array, int target) {
        int result = 0;
        int start = 0;
        int end = array.length - 1;


        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int num = array[mid];
            if (target == num) {
                //return fnFindNumber2(array,mid);
                start = fnFindStart(array, start, mid, target);
                end = fnFindEnd(array, mid, end, target);

                return end - start + 1;
            }

            if (num < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    private static int fnFindEnd(int[] array, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int num = array[mid];

            if (num == target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static int fnFindStart(int[] array, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int num = array[mid];

            if (num == target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

//    private static int fnFindNumber2(int[] array, int index) {
//        int result = 1;
//        int target = array[index];
//        int up = index + 1;
//        int down = index - 1;
//
//        while (up < array.length && target == array[up]) {
//            result++;
//            up++;
//        }
//
//        while (down >= 0 && target == array[down]) {
//            result++;
//            down--;
//        }
//
//        return result;
//    }


}
