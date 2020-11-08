package Test;

import java.util.ArrayList;
import java.util.List;

public class HomeTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			if(i%2 ==0)
			list.remove(i);
		}
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
