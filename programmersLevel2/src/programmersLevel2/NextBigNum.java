package programmersLevel2;

import java.util.regex.Pattern;

public class NextBigNum {
	public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int first = binary.lastIndexOf("1");
        int last = binary.lastIndexOf("0", first);
        int length;
        int one;
        if(last==-1) {
        	binary = "10"+binary.substring(1);
        }else {
        	length = binary.length()-last;
        	one = first-last;
        	binary = binary.substring(0, last)+binary.replaceAll(binary.substring(last), "");
        }
        
        answer = Integer.parseInt(binary, 2);
        return answer;
    }
}
