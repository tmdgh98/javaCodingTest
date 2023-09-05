//3
//1 0
//5
//4 2
//1 2 3 4
//6 0
//1 1 9 1 1 1
package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Print {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list;
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			list = new ArrayList<Integer>();
			String[] nm = br.readLine().split(" ");
			String[] arr = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			for(String str : arr) {
				list.add(Integer.parseInt(str));
			}

			int count = 1;
			while(true) {
				boolean a = true;
				for (int j = 1; j < list.size(); j++) {
					if(list.get(0)<list.get(j)) {
						list.add(list.get(0));
						list.remove(0);
						if(m==0) {
							m=list.size()-1;
						}else {
							m--;
						}
						a = false;
						break;
					}					
				}
				if(a) {
					if(m==0) {
						System.out.println(count);
						break;
					}else {
						list.remove(0);
						count++;
						m--;
					}
				}
				
			}
			
			
		}
	}
}
