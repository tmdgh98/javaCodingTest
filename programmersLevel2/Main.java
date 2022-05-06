import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());
        int[] noArr = new int[m];
        boolean[] arrCheck = new boolean[10];
        int[] arr = new int[10 - m];
        if(m!=0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                noArr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(noArr);
        }

        for (int i : noArr) {
            arrCheck[i] = true;
        }

        int arrIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (arrCheck[i] == false) {
                arr[arrIndex] = i;
                arrIndex++;
            }
        }

        System.out.println(Arrays.toString(arr));

        int first = n;
        int length = 1;
        while (first / 10 != 0) {
            length++;
            first = first / 10;
        }

        //+-로만이동하는경우
        int case1 = n > 100 ? n - 100 : 100 - n;

        //채널선택후+로 이동하는경우
        int case2 = -1;
        for (int i : arr) {
            if (i >= first) {
                break;
            } else {
                case2 = i;
            }
        }

        if (case2 == 0) {
            case2 = n + 1;
        } else if (case2 != -1) {
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    case2 = case2;
                } else {
                    case2 = case2 * 10 + arr[arr.length - 1];
                }
            }
        }



        //채널선택후-로 이동하는경우
        int case3 = -1;
        for (int i : arr) {
            if (i >= first) {
                case3 = i;
                break;
            }
        }
        if (case3 == 0) {
            case3 = -1;
        } else if (case3 != -1) {
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    case3 = case3;
                } else {
                    case3 = case3 * 10 + arr[0];
                }
            }
        }


        System.out.println(case1);
        System.out.println(case2);
        System.out.println(case3);
        System.out.println(length);

        case2 = n - case2 + length;
        case3 = case3 - n + length;

        int res = case1;

        if (case2 > 0) {
            res = Math.min(res, case2);
        }

        if (case3 > 0) {
            res = Math.min(res, case3);
        }

        System.out.println(res);
    }
}
