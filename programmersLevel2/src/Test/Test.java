package Test;



public class Test{
	public static void main(String[] args) {
		int a = 1;
		for (int i = 0; i < 4; i++) {
			a *= 13;
		}
		
		a = a%12;
		
		System.out.println(a);
		a=1;
		for (int i = 0; i < 4; i++) {
			a *= 13;
			a %= 12;
		}
		System.out.println(a);
	}
}
