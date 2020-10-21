package Test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
//		String a = "a";
//		a.equals(anObject);
		List<Testvo> a = new ArrayList<>();
		
		a.add(new Testvo("1", "2", "2"));
		a.get(0).getId().equals(args[0]);
		
		a.toString();
		
	}
}
