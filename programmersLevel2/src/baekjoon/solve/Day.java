package baekjoon.solve;

import java.util.Scanner;

public class Day {
	public static void main(String[] args) {
		String[] days = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner sc= new Scanner(System.in);
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		for (int i = 0; i < month-1; i++) {
			day += months[i];
		}
		
		System.out.println(days[day%7]);
				
		
	}
}
