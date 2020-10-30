package backjun.solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WordNum {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split(" ");
	
		if(a.length==0) {
			System.out.println(0);
		}else if(a[0].equals("")) {
			System.out.println(a.length-1);
		}else {
			System.out.println(a.length);
		}
	}
}
