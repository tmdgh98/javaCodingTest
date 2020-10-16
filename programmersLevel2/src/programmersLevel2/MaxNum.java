package programmersLevel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaxNum {
	public String solution(int[] numbers) {
        String answer = "";
        Arrays.sort(numbers);
        
        for (int i: numbers) {
			System.out.print(i);
		}
        return answer;
    }
}
