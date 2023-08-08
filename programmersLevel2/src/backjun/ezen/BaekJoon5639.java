package backjun.ezen;

import java.io.IOException;
import java.util.Scanner;

public class BaekJoon5639 {

    static class Node {
        int value;

        Node right;
        Node left;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    static Node rootNode;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        rootNode = new Node(sc.nextInt());

        while (sc.hasNext()) {
            fnMakeTree(sc.nextInt(), rootNode);
        }

        fnPostorderTraverse(rootNode); //후위순회

        System.out.println(sb);

    }

    private static void fnPostorderTraverse(Node node) {
        //왼쪽
        if (node.left != null) {
            fnPostorderTraverse(node.left);
        }
        //오른쪽
        if (node.right != null) {
            fnPostorderTraverse(node.right);
        }
        //자기자신
        sb.append(node.value);
        sb.append("\n");
    }

    private static void fnMakeTree(int value, Node node) {
        Node nextNode;
        if (node.value < value) {
            nextNode = node.right;
        } else {
            nextNode = node.left;
        }

        if (nextNode == null) {
            nextNode = new Node(value);
            if (node.value < value) {
                node.right = nextNode;
            } else {
                node.left = nextNode;
            }
        } else {
            fnMakeTree(value, nextNode);
        }
    }
}
