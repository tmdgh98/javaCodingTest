//지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
//
//지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
//
//첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
//왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
//오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
//큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. 
//(이 위치는 가장 처음 큐에서의 위치이다.) 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 
//2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
package baekjoon.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class RotatingQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			list.add(i+1);
		}
		int n=sc.nextInt();
		int count=0;
		for (int i = 0; i < n; i++) {
			int target = sc.nextInt();
			int length=0;
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j)==target) {
					length = j;
					break;
				}
			}
			boolean tw = ((list.size()-length)>length)?true:false;
			while(list.get(0)!=target) {
				if(tw) {
					count++;
					list.add(list.get(0));
					list.remove(0);
				}else {
					count++;
					list.add(0, list.get(list.size()-1));
					list.remove(list.size()-1);
				}
			}
			list.remove(0);
		}
		System.out.println(count);
		
	}
}


