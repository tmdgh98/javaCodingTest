package Test;



public class Test{
	public static void main(String[] args) {
		test2 te = new test2();
		
		int sum =te.sum(10,11);
		System.out.println(sum);
		
		te.sum(4.5, 5.5);
		String a = "abcdeadfsag";
		
		System.out.println(a.substring(1));
		System.out.println(a.substring(1, 3));
	}
}
