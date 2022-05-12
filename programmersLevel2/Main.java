import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.Comparator;
=======
import java.lang.reflect.Array;
import java.util.Arrays;
>>>>>>> origin/master
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
<<<<<<< HEAD
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int arr[][] = new int[k][2];
        long total = 0;
        for (int i = 0; i < k; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            total += arr[i][0];
        }

        int length = (int) (total / n);
        boolean bol = fnCheck(arr, length, n);

        if (bol == false) {
            for (int i = 0; i < k; i++) {
                int line = arr[i][0];
                int cut = line / length + 1;
                arr[i][1] = line / cut;
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] > o2[1] ? 1 : -1;
                }
            });

            int index = fnFind(arr, n);
            //System.out.println(index);
            length = arr[index][1];
        }

        System.out.println(length);

    }

    private static int fnFind(int[][] arr, int n) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;

            int line = arr[mid][0];
            boolean check = fnCheck(arr, arr[mid][1], n);

//            System.out.println(Arrays.toString(arr[mid]));
//            System.out.println(check);
//            System.out.println(n);
            if (check == true) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private static boolean fnCheck(int[][] arr, int length, int n) {
        long count = 0;
        for (int[] line : arr) {
            count += line[0] / length;
        }
        return n <= count ? true : false;
=======
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
>>>>>>> origin/master
    }
}
