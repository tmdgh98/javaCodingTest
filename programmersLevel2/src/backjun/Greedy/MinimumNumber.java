package backjun.Greedy;

import java.util.Scanner;

public class MinimumNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		
		String[] plus;
				
		plus = a.split("\\+");
		
		String[] number;
		int num = 0;
		boolean boo = true;
		boolean bool = true;
		for (int i = 0; i < plus.length; i++) {
			number = plus[i].split("-");
			if(number.length>1) {
				boo = false;
			}
			if(boo) {
				num+=Integer.parseInt(number[0]);
			}else{
				for (int j = 0; j < number.length; j++) {
					if(bool) {
						num += Integer.parseInt(number[0]);
						bool = false;
					}else {
						num-=Integer.parseInt(number[j]);
					}
				}
			}
			
		}
		
		System.out.println(num);
	}
}
