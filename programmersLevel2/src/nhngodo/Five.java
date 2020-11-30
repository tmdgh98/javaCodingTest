//5/5 투표 조작
//시간 제한 : 2초메모리 제한 : 256MB
//문제 설명
//당신은 모든 유권자가 다음 선거에서 어떻게 투표할지 알아내기 위해서 생각을 읽을 수 있는 비밀 기계를 이용했다. 
//생각을 읽는 기계는 또한 당신이 충분한 돈을 지불하면 모든 유권자가 투표를 바꿀 준비가 되어 있음을 밝혀주었다.
//
//주어진 int[] votes에서 i번째 요소는 원래 후보 i에게 투표하려고 생각했던 사람의 수이다. 
//당신이 원하는 후보 0이 다른 후보들보다 더 많이 득표하기 위해 반드시 바꿔야 하는 투표의 최소 숫자를 반환하여라.
//
//참고 / 제약 사항
//votes는 1개 이상, 50개 이하의 요소를 가진다.
//votes의 각 요소는 1 이상, 100 이하이다.
//테스트 케이스
//int[] votes = [5,7,7]리턴(정답): 2
//다른 두 후보에게서 1표씩 산다면 후보 0이 7표가 되고 나머지 두 후보는 6표가 된다.
//
//int[] votes = [10,10,10,10]리턴(정답): 1
//후보 0의 투표수는 다른 후보들의 투표수를 초과해야 한다. 따라서 한표만 더 있으면 된다.
//
//int[] votes = [1]리턴(정답): 0
//후보 0이 유일한 후보라면 표를 사지 않아도 된다.
//
//int[] votes = [5,10,7,3,8]리턴(정답): 4
//int[] votes = [100]리턴(정답): 0

package nhngodo;

import java.util.Arrays;

public class Five {
	public static void main(String[] args) {
		
		int[] a = {100, 105, 104, 40};
		System.out.println(solution(a));
				
	}
	
	public static int solution(int[] votes) {
		if(votes.length==1){
            return 0;
        }
        int[] rival = new int[votes.length-1];
        for (int i=0; i<rival.length; i++){
            rival[i] = votes[i+1];
        } 
        
        Arrays.sort(rival);
        int size = rival.length-1;
        int score = rival[size]; //1등 점수
        int firstNum = 0; //1등 숫자
        int idx = 0; // 1등 조회 번호
        int count = 0; // 리턴값
        int myScore = votes[0]; 
        
        for(int i=size; i>0; i--){
            if(rival[i]>rival[i-1]){
                break;
            }
            firstNum++;
        }
        
        while(myScore <= score){
            myScore++;
            rival[size-idx]--;
            if(firstNum>idx) idx++;
            else{
                for(int i = size-firstNum; i>0; i--){
                    if(rival[i]>rival[i-1]){
                        break;
                    }
                    firstNum++;
                }
                idx = 0;
                score = rival[size];
            }
            count++;
        }
        
        return count;
	}
}
