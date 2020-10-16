package backjun.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FastInOut {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a,b,sum;
		String[] temp=new String[2];
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			sum = a+b;
			bw.write(sum + "\n");
			
		}
		bw.flush();
	}
}
