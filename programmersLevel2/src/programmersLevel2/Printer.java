package programmersLevel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Printer {
	public int solution(int[] priorities, int location) {
        int answer = 0;
        int print = priorities[location];
        priorities[location] = 0;
        String temp;
        String num;
        int point=0;
        String pri="";
        for (int i = 0; i < priorities.length; i++) {
			if(priorities[i]>print) {
				answer++;
			}
			pri = pri+priorities[i];
		}
        for (int i = 9; i > print; i--) {
        	num = Integer.toString(i);
			if(pri.indexOf(num)>=0) {
	        	point=pri.lastIndexOf(num);
				temp=pri.substring(0, point);
				pri = pri.replaceFirst(temp, "");
				pri = pri+temp;
				pri = pri.replace(num, "");
			}
		}
        for (int i = 1; i < print; i++) {
			num = Integer.toString(i);
        	pri=pri.replace(num,"");
		}
        
        return answer+pri.indexOf('0')+1;
    }
	//1등풀이
//	public int solution(int[] priorities, int location) {
//        int answer = 0;
//        int l = location;
//
//        Queue<Integer> que = new LinkedList<Integer>();
//        for(int i : priorities){
//            que.add(i);
//        }
//
//        Arrays.sort(priorities);
//        int size = priorities.length-1;
//
//
//
//        while(!que.isEmpty()){
//            Integer i = que.poll();
//            if(i == priorities[size - answer]){
//                answer++;
//                l--;
//                if(l <0)
//                    break;
//            }else{
//                que.add(i);
//                l--;
//                if(l<0)
//                    l=que.size()-1;
//            }
//        }
//
//        return answer;
//    }
}
