package programmersLevel2;

import java.util.Stack;

public class NJinsu {
	public String solution(int n, int t, int m, int p) {
        char[] over = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'};
        String[] que = new String[15];
		String answer = "";
        int gamenum;
		int num=0;
		int divnum =0;
		int count = 0;
		int anscount =0;
		int point=1;
		que[0]="0";
		while(anscount<t) {
			while(divnum>0) {
				gamenum=divnum%n;
				divnum/=n;
				if(gamenum>9) {
					que[point] = over[gamenum-10]+"";
					point++;
				}else {
					que[point] = gamenum+"" ;
					point++;
				}				
			}
			if(count%m == p-1) {
				answer = answer + que[point-1];
				anscount++;
				
			}
			point--;
			if(point == 0) {
				num++;
				divnum = num;
			}
			count++;
		}
        return answer;
    }
	
	public String solution2(int n, int t, int m, int p) {
		String answer = "";
		char[] numeralSystem = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] sequence = new char[t*m];
		Stack<Character> stack = new Stack<>();
		int count = 0;
		int number = 0;
		int temp = number;
		int limit = m*t;
		
		while(count < limit) {
			if(temp < n) {
				sequence[count] = numeralSystem[temp];
				count++;
				while(!stack.isEmpty() && count < limit) {
					sequence[count] = stack.pop();
					count++;
				}
				number++;
				temp = number;
			}else {
				stack.push(numeralSystem[temp%n]);
				temp /= n;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = p - 1; i < sequence.length; i+=m) {
            sb.append(sequence[i]);
        }
		return answer = sb.toString();
	}
}
//while(anscount<t) {
//if(divnum==0) {
//	num++;
//	divnum = num;
//}
//gamenum=divnum%n;
//divnum /= n;
//System.out.println(gamenum);
//if(count%m==p-1) {
//	if(gamenum>9) {
//		answer = answer+over[gamenum-10];
//		anscount++;
//	}else {
//		answer = answer+gamenum ;
//		anscount++;
//	}
//}
//count++;
//}
