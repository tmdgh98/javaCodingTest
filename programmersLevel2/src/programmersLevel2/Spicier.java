package programmersLevel2;

import java.util.Arrays;

public class Spicier {
	public int solution(int[] scoville, int K) {
        int si = 0;
        int ai = 0;
        Arrays.sort(scoville);
        int[] arr = new int[scoville.length];
        while(scoville[si]<K) {
        	scoville[ai]=scoville[si+1]*2+scoville[si];
        	si++;
        	if(si == scoville.length-1) {
        		if(scoville[si]<K) si=-1;
        		break;
        	}
        	
        }
        return si;
    }
}
