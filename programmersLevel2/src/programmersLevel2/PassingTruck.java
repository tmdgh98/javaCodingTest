package programmersLevel2;

public class PassingTruck {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 1;
        int start =0;
        int end = 0;
        int len =truck_weights.length;
        int[] pass = new int[len];
        int wei = 0;
        int num= 0;
        
        while(pass[len-1]<bridge_length) {
	        if(num<len&&wei+truck_weights[num]<=weight) {
	        	wei += truck_weights[num];
	        	end++;
	        	num++;
	        }
	        for(int i = start; i <end; i++) {
	        	pass[i]++;
	        	if(pass[i]==bridge_length) {
	        		wei -=truck_weights[i];
	        		start++;
	        	}
	        }
	        answer++;
        }
        
        return answer;
    }
}
