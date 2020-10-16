package programmersLevel2;

public class JadenCase {
	public String solution(String s) {
        String answer = "";
        int num=0;
        int a;
        int z;
        for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' ') {
				num=0;
				answer = answer+s.charAt(i);
			}else {
				if(num==0) {
					a = s.charAt(i)-'a';
					z = s.charAt(i)-'z';
					if(a>=0&&z<=0) {
						answer = answer+(char)(s.charAt(i)-32);
					}else {
						answer = answer+s.charAt(i);
					}
				}else {
					a=s.charAt(i)-'A';
					z=s.charAt(i)-'Z';
					if(a>=0&&z<=0) {
						answer = answer+(char)(s.charAt(i)+32);
					}else {
						answer = answer+s.charAt(i);
					}
				}
				num++;
			}
			
		}
        
        return answer;
    }
}
