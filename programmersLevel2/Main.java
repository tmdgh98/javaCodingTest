import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
    }
}
