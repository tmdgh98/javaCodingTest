package backjun.solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Print2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(str!=null) {
			System.out.println(str);
			str = br.readLine();
		}
	}
}
