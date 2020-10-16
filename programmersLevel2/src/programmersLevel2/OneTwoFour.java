package programmersLevel2;

public class OneTwoFour {
	public String solution(int n) {
		String answer = "";
        String[] otf = {"4","1","2"};
        int num;
        
        while(n>0) {
        	num=n%3;
        	answer= otf[num]+answer;
        	n=(n-1)/3;
        }
        return answer;
    }

}
