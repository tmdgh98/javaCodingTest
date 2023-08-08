package backjun.ezen;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon12851 {

    static class Node {
        int number;
        int depth;

        Node(int n, int d) {
            this.number = n;
            this.depth = d;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int depth = Integer.MAX_VALUE;
        int cnt = 0;
        int[] visit = new int[100000*2+1];

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(n, 0));
        int num, d, nextNum;
        while (que.isEmpty() == false) {
            Node node = que.poll();
            num = node.number;
            d = node.depth;

            if (k == num) {
                depth = d;
                cnt++;
                continue;
            }

            //case1 -1
            nextNum = num - 1;
            if (d < depth && -1 < nextNum) {
                if (visit[nextNum] == 0 || d < visit[nextNum]) {
                    que.add(new Node(nextNum, d + 1));
                    visit[nextNum] = d + 1;
                }
            }
            //case2 +1
            nextNum = num + 1;
            if (d < depth && -1 < nextNum  && nextNum <= 200000) {
                if (visit[nextNum] == 0 || d < visit[nextNum]) {
                    que.add(new Node(nextNum, d + 1));
                    visit[nextNum] = d + 1;
                }
            }
            //case3 *2
            nextNum = num * 2;
            if (d < depth && nextNum <= 200000) {
                if (visit[nextNum] == 0 || d < visit[nextNum]) {
                    que.add(new Node(nextNum, d + 1));
                    visit[nextNum] = d + 1;
                }
            }
        }

        System.out.println(depth);
        System.out.println(cnt);
    }

}
