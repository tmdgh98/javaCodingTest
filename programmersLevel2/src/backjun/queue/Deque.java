//정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//명령은 총 여덟 가지이다.
//
//push_front X: 정수 X를 덱의 앞에 넣는다.
//push_back X: 정수 X를 덱의 뒤에 넣는다.
//pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 덱에 들어있는 정수의 개수를 출력한다.
//empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
package backjun.queue;

import java.util.Scanner;

public class Deque {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[20002]; 
		int front=10001;
		int back=10000;
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			
			if(str.equals("push_front")) {
				int integer = sc.nextInt();
				arr[front] = integer;
				front++;
			}else if(str.equals("push_back")) {
				int integer = sc.nextInt();
				arr[back] = integer;
				back--;
			}else if(str.equals("pop_front")) {
				if(back==front-1) {
					sb.append(-1+"\n");
				}else {
					front--;
					sb.append(arr[front]+"\n");
				}
			}else if(str.equals("pop_back")) {
				if(back==front-1) {
					sb.append(-1+"\n");
				}else {
					back++;
					sb.append(arr[back]+"\n");
				}
			}else if(str.equals("size")) {
				int size = front-back-1;
				sb.append(size+"\n");
			}else if(str.equals("empty")) {
				if(back==front-1) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
			}else if(str.equals("front")) {
				if(back==front-1) {
					sb.append(-1+"\n");
				}else {
					sb.append(arr[front-1]+"\n");
				}
			}else if(str.equals("back")) {
				if(back==front-1) {
					sb.append(-1+"\n");
				}else {
					sb.append(arr[back+1]+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
