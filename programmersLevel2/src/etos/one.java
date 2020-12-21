package etos;

import java.util.Stack;

public class one {
	public static void main(String[] args) {
		String[] a = {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
		System.out.println(solution(a));
	}
	public static int solution(String[] ledgers) {
        int answer = 0;
        Stack<int[]> stack = new Stack<>();
        for(String str : ledgers){
            int[] array = new int[4];
            String[] temp = new String[3];
            String[] temp2 = new String[2];
            temp = str.split(" ");
            temp2 = temp[0].split("/");
            array[0] = Integer.parseInt(temp2[0]);
            array[1] = Integer.parseInt(temp2[1]);
            array[2] = Integer.parseInt(temp[1]);
            array[3] = Integer.parseInt(temp[2]);
            
            if(array[3]>=0){
                stack.push(array);
            }else{
                while(true){
                	int[] pre = stack.pop();
                    array[3] += pre[3];
                    if(array[3]>=0){
                        answer += (pre[3]-array[3])*pre[2]/100*date(pre,array)/365;
                        pre[3] = array[3];
                        System.out.println(answer);
                        stack.push(pre);
                        break;
                    }else{
                        answer += (pre[3])*pre[2]/100*date(pre,array)/365;
                        System.out.println("e "+answer);
                    }
                }
            }
        }
        while(!stack.empty()){
            int[] pre = stack.pop();
            int[] last = {12,31};
            answer += (pre[3])*pre[2]/100*date(pre,last)/365;
            System.out.println("l "+answer);
        }
        return answer;
    }
    
    public static int date(int[] a, int[] b){
        int[] m = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int datea = a[1];
        int dateb = b[1];
        for(int i=0; i< a[0]; i++){
            datea += m[i];
        }
        for(int i=0; i< b[0]; i++){
            dateb += m[i];
        }
        return dateb - datea;
    }
}
