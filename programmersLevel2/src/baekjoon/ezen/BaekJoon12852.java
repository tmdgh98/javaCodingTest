package baekjoon.ezen;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon12852 {

    static class Node {
        StringBuilder sb;
        int index;
        int cnt;

        Node(int index, int cnt, StringBuilder sb) {
            this.index = index;
            this.cnt = cnt + 1;

            this.sb = new StringBuilder();
            this.sb.append(sb.toString());
            //    this.sb = sb;
            this.sb.append(index);
            this.sb.append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(n, -1, sb));

        boolean[] visit = new boolean[n + 1];

        int index;
        while (que.isEmpty() == false) {
            Node node = que.poll();
            if (node.index == 1) {
                System.out.println(node.cnt);
                System.out.println(node.sb);
                break;
            }

            index = node.index;
            //X가 3으로 나누어 떨어지면, 3으로 나눈다.
            if (index % 3 == 0 && visit[index / 3] == false) {
                visit[index / 3] = true;
                que.add(new Node(index / 3, node.cnt, node.sb));
            }
            //X가 2로 나누어 떨어지면, 2로 나눈다.
            if (index % 2 == 0 && visit[index / 2] == false) {
                visit[index / 2] = true;
                que.add(new Node(index / 2, node.cnt, node.sb));
            }
            //1을 뺀다.
            if (visit[index - 1] == false) {
                visit[index - 1] = true;
                que.add(new Node(index - 1, node.cnt, node.sb));
            }
        }
    }


}
