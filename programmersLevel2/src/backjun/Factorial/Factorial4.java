package backjun.Factorial;

import java.util.Scanner;

public class Factorial4 {
	public static int[] location;
	public static int count=0;
	public static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = ans*2+1;
		}
		answer = ans;
		System.out.println(ans);
		location = new int[n];
		for (int i = 0; i < location.length; i++) {
			location[i] = 1;
		}
		hanoi(n,ans);
	}
	public static void hanoi(int n,int ans){
		int target = 3;
		int rest=2;
		solution(n,true,target,rest);
		
	}
	public static void solution(int n, boolean updown, int target, int rest) {
		
		if(count==answer) {
			//end
		}else if(n==1) {			
			System.out.println(location[0]+" "+target);
			count++;
			rest = 6-target-location[0];
			location[0]=target;
			solution(n+1,false,3,2);			
		}else if(updown == false&&location[n-1]==location[n-2]) {
			solution(n+1,false,target,rest);
		}else if(updown == true&&location[n-1]==location[n-2]) {
			solution(n-1,true,rest,target);
		}else{		
			target = 6-location[0]-location[n-1];
			System.out.println(location[n-1]+" "+target);
			count++;
			location[n-1] = target;
			solution(n-1,true,target,6-target-location[0]);
		}
	}
}
