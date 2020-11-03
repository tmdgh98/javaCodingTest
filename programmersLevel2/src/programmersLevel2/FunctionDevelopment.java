package programmersLevel2;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelopment {
	    public int[] solution(int[] progresses, int[] speeds) {
	        int[] answer;
	        List<Integer> list = new ArrayList<Integer>();
	        int count = 0;
	        int n=0;
	        boolean print = false;
	        while(n<progresses.length) {
		        for (int i = n; i < progresses.length; i++) {
		        	if(n==progresses.length-1) {
		        		list.add(++count);
		        	}
		        		
		        	progresses[i]+=speeds[i];
					if(progresses[n]>=100) {
						count++;
						n++;
						print = true;
					}else {
						if(print) {
							list.add(count);
							print = false;
						}
						count = 0;
					}
				}
	        }
	        answer = new int[list.size()];
	        for (int i = 0; i < answer.length; i++) {
				answer[i] = list.get(i);
			}
	        return answer;
	    }
	}
//	public int[] solution(int[] progresses, int[] speeds) {
//                
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		int spnum=1;
//		int num=0;
//		int count;
//        for (int i = 0; i < progresses.length; i++) {
//			while(num<100) {
//				num = progresses[i] + speeds[i]*spnum;
//				spnum++;
//			}
//			count=count(i,spnum,progresses,speeds);
//			list.add(count);
//			i += count-1;
//		}
//        int[] answer = new int[list.size()];
//        for(int a : list) {
//        	int i = 0;
//        	answer[i] = a;
//        	i++;
//        }
//        
//        return answer;
//    }
//	
//	public int count(int num, int spnum, int[] progresses, int[] speeds) {
//		int count=0;
//		
//		int jub = progresses[num]+speeds[num]*spnum;
////		if(num<progresses.length&&jub >= 100) {
////			count++;
////			count=count(num+1,spnum,progresses,speeds);
////		}else {
////			return count;
////		}
//		return count;
//	}

