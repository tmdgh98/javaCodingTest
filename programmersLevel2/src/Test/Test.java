package Test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 5; i++) {
			list.add(1);
		}
		list.add(0, 2);
		for(int a : list) {
			System.out.println(a);
		}
	
	}
}
