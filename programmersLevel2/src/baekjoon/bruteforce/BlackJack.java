package baekjoon.bruteforce;

import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("카드숫자");
		int n = sc.nextInt();
		int[] card = new int[n];
		System.out.println("카드합");
		int goal = sc.nextInt();
		System.out.println("카드번호 "+n+"개 입력");
		for (int i = 0; i < card.length; i++) {
			card[i] = sc.nextInt();
		}
		int sum=0;
		int max=0;
		loop:
		for (int i = 0; i < card.length-2; i++) {
			for (int j = i+1; j < card.length-1; j++) {
				for (int k = j+1; k < card.length; k++) {
					sum=card[i]+card[j]+card[k];
					if(sum==goal) {
						max = sum;
						break loop;
					}else if(sum<goal&&max<sum){
						max=sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}
