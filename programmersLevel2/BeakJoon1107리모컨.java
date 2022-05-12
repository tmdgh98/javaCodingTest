import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeakJoon1107리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());
        int[] noArr = new int[m];
        boolean[] arrCheck = new boolean[10];
        int[] arr = new int[10 - m];
        if (m != 0) {
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

        //+-로만이동하는경우
        int case1 = n > 100 ? n - 100 : 100 - n;

        String str = Integer.toString(n);
        String[] strArr = str.split("");

        //일치하지않는숫자 찾기
        boolean ck = false;
        int temp = 0;
        int difIndex = -1;
        int length = strArr.length;

        for (int i = 0; i < length; i++) {
            int num = Integer.parseInt(strArr[i]);
            if (ck == false && arrCheck[num] == true) {
                ck = true;
                difIndex = i;
            } else if (ck == true) {
                temp *= 10;
                temp += Integer.parseInt(strArr[i]);
            }
        }

        int case2 = -1;
        int case3 = -1;
        int case23 = 0;
        int case2Length = length;
        int case3Length = length;

        if (difIndex == -1) {
            case2 = 0;
        } else if (arr.length > 0) {
            for (int i = difIndex; i < strArr.length; i++) {
                int num = Integer.parseInt(strArr[i]);
                case23 *= 10;
                case23 += num;
                if (i == difIndex) {
                    for (int k : arr) {
                        if (num < k) {
                            break;
                        }
                        case2 = k;
                    }
                    if (case2 == -1) {
                        case2 = arr[arr.length - 1];
                        case2Length--;
                        i++;
                    }
                } else {
                    case2 *= 10;
                    case2 += arr[arr.length - 1];
                }
            }

            for (int i = difIndex; i < strArr.length; i++) {
                int num = Integer.parseInt(strArr[i]);
                if (i == difIndex) {
                    for (int k : arr) {
                        if (num < k) {
                            case3 = k;
                            break;
                        }
                    }
                } else {
                    if (case3 != -1) {
                        case3 *= 10;
                        case3 += arr[0];
                    } else {
                        case3 = (arr[0] == 0 ? (arr.length > 1 ? arr[1] : arr[0]) : arr[0]) * 100;
                        case3 += arr[0] * 10;
                        case3 += arr[0];
                        case3Length++;
                    }
                }
            }
        }


        System.out.println(Arrays.toString(arr));
        System.out.println(case1);
        System.out.println(case2);
        System.out.println(case3);
        System.out.println(case23 + " " + difIndex + " " + case2Length + " " + case3Length);
        System.out.println(length);


        int res = case1;
        if (case2 > -1) {
            case2 = case23 - case2 + case2Length;
        }
        if (case2 > -1) {
            res = Math.min(res, case2);
        }

        if (case3 > -1) {
            case3 = case3 - case23 + case3Length;
        }
        if (case3 > -1) {
            res = Math.min(res, case3);
        }

        System.out.println(res);
    }
}
