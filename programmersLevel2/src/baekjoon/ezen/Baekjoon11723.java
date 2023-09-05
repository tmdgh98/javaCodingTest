package baekjoon.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon11723 {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        String cmd;
        int x;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            if ("add".equals(cmd)) {
                x = Integer.parseInt(st.nextToken());
                add(x);
            } else if ("remove".equals(cmd)) {
                x = Integer.parseInt(st.nextToken());
                remove(x);
            } else if ("check".equals(cmd)) {
                x = Integer.parseInt(st.nextToken());
                sb.append(check(x));
                sb.append("\n");
            } else if ("toggle".equals(cmd)) {
                x = Integer.parseInt(st.nextToken());
                toggle(x);
            } else if ("all".equals(cmd)) {
                all();
            } else if ("empty".equals(cmd)) {
                empty();
            }
        }

        System.out.println(sb);
    }

    private static int find(int x) {
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == x) {
                index = i;
                break;
            }
        }

        return index;
    }

    private static void add(int x) {
        int index = find(x);
        if (index == -1) {
            list.add(x);
            Collections.sort(list);
        }
    }

    private static void remove(int x) {
        int index = find(x);
        if (index != -1) {
            list.remove(index);
        }
    }

    private static int check(int x) {
        int res = 0;
        if (find(x) != -1) {
            res = 1;
        }
        return res;
    }

    private static void toggle(int x) {
        int index = find(x);
        if (index == -1) {
            list.add(x);
            Collections.sort(list);
        } else {
            list.remove(index);
        }
    }

    private static void all() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        list = new ArrayList<>(Arrays.asList(arr));
    }

    private static void empty() {
        list = new ArrayList<>();
    }


}
