package src.backjun.unClassified;

import java.util.Scanner;
import java.util.Stack;

/**
 * 스택응용문제
 * 
 * 근데 이문제를 다시봤을때 내가 스택을 떠올릴수있을까 ㅋㅋㅋㅋ
 * */

public class BeakJoon1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.next();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char t;

            if ('Z' >= c && c >= 'A') {
                sb.append(c);
                continue;
            } else if (c == ')') {
                while (stack.isEmpty() == false) {
                    t = stack.pop();
                    if (t == '(') {
                        break;
                    } else {
                        sb.append(t);
                    }
                }
                continue;
            } else if (c == '*' || c == '/') {
                while (stack.isEmpty() == false) {
                    t = stack.peek();
                    if (t == '*' || t == '/') {
                        sb.append(stack.pop());
                    }else{
                        break;
                    }
                }

            } else if (c == '+' || c == '-') {
                while (stack.isEmpty() == false) {
                    t = stack.peek();
                    if (t == '*' || t == '/' || t == '+' || t == '-') {
                        sb.append(stack.pop());
                    }else{
                        break;
                    }
                }
            }
            stack.push(c);
        }

        while (stack.isEmpty() == false) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
