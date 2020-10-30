package backjun.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScanPrint {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		while(str!=null) {
			
			System.out.println(str);
			
			str = br.readLine();
		}
		
		
	}
}
