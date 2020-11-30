//3/5 거친 문자열
//시간 제한 : 2초메모리 제한 : 256MB
//문제 설명
//문자열 String s의 거친 정도는 다음과 같이 계산할 수 있다. s에서 가장 많이 등장하는 글자를 c1이라 하고, 
//가장 적게 등장하는 글자를 c2라 한다 (c2는 반드시 한번 이상은 등장해야 한다). 
//s의 거친 정도는 c1이 등장하는 횟수에서 c2가 등장하는 횟수를 뺀 숫자이다.
//
//당신은 주어진 문자열 s에서 0개 이상, int n개 이하의 글자를 삭제하는 방법으로 문자열을 변경할 수 있다 
//(명확한 이해를 위해 예제를 참조하라). 이 방법을 이용하여 얻을 수 있는 가장 적은 문자의 거친 정도를 반환하여라.
//
//참고 / 제약 사항
//s는 1개 이상, 50개 이하의 글자를 가진다.
//s는 소문자만 가진다 ('a'-'z').
//n은 0이상, m-1이하이다. 이 때, m은 s에 있는 글자의 개수이다.
//테스트 케이스
//String s = "aaaaabbc"
//int n = 1리턴(정답): 3
//하나의 'a'를 삭제하거나 하나의 'c'를 삭제하여 최소의 거친 정도 3을 얻을 수 있다.
//
//String s = "aaaabbbbc"
//int n = 5리턴(정답): 0
//'c'와 모든 'a'를 지우는 방법이 있다.

package nhngodo;

public class Three {
	public static void main(String[] args) {
//		//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
//		import java.util.Arrays;
//
//		public class Solution{
//		    public int solution(String s, int n){
//		        int[] num = new int[26]; // 알파벳 개수 배열
//		        for (int i = 0 ; i<s.length() ; i++){
//		            char ch = s.charAt(i);
//		            num[ch-'a']++; 
//		        } 
//		        
//		        Arrays.sort(num);
//		        
//		        int minNum = 0; //개수가 0개가 아닌 최소값
//		        for(int i=0; i< 26; i++){
//		            if(num[i]!=0){
//		                minNum=i;
//		                break;
//		            }
//		        }
//		        
//		        if(minNum==25){ //알파벳이 한개뿐일경우
//		            return num[25]-n>0 ? num[25]-n : 0;
//		        }else if(minNum==24){ //알파벳이 2개뿐일 경우
//		            return num[25]-num[24]-n>0 ? num[25]-num[24]-n : 0;
//		        }
//		        
//		        
//		        //num[25]가 가장개수가 많은 알파벳, num[minNum]가 가장 개수가 작은 알파벳
//		        int[] answer = new int[2];
//		        if(n >= num[minNum]) answer[0] = num[25]-num[minNum+1]; 
//		        if(num[25]-n>num[24]) answer[1] = num[25]-n-num[minNum];
//		        else answer[1] = num[24]-num[minNum];
//		        
//		        return answer[0]>answer[1]? answer[1]:answer[0];
//		    }
//		}
	}
}
