//정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//명령은 총 여섯 가지이다.
//
//push X: 정수 X를 큐에 넣는 연산이다.
//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

package baekjoon.queue;

import java.util.Scanner;

public class Queue02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];
		String str;
		int front = 0;
		int back = 0;
		
		for (int i = 0; i < n; i++) {
			str = sc.next();
			if(str.equals("push")) {
				arr[front] = sc.nextInt();
				front++;
			}else if(str.equals("pop")) {
				if(front==back) {
					sb.append(-1+"\n");
				}else {
					sb.append(arr[back]+"\n");
					back++;
				}
			}else if(str.equals("size")) {
				sb.append(front-back+"\n");
			}
			else if(str.equals("empty")) {
				if(back==front) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
			}
			else if(str.equals("front")) {
				if(back==front) {
					sb.append(-1+"\n");
				}else {
					sb.append(arr[back]+"\n");
				}
			}
			else if(str.equals("back")) {
				if(back==front) {
					sb.append(-1+"\n");
				}else {
					sb.append(arr[front-1]+"\n");
				}
			}
			
		}
		
		System.out.println(sb);
	}
}
