
import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer> llist = new ArrayList<>();
    private static List<Integer> rlist = new ArrayList<>();
    private static int[] arr;

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
        fnSet(0, n / 2, 0, rlist);


        int cnt = fnTwoPoint();

        if(s == 0){
            cnt--;
        }
        System.out.println(cnt);
    }

    private static int fnTwoPoint() {

        return 0;
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
