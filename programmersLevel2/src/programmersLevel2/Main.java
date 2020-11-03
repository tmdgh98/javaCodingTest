package programmersLevel2;

import java.util.Arrays;
import java.util.regex.Pattern;

import javax.xml.transform.Source;

public class Main {

	public static void main(String[] args) {
		TrianglularSnail ts = new TrianglularSnail();
		int[] arr = ts.solution(3);
		
		for(int a : arr) {
			System.out.print(a+" ");
			
		}
	}

}
//[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]