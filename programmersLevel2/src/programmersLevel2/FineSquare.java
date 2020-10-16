package programmersLevel2;

public class FineSquare {
	public static long solution(int w, int h) {
        long answer=0;
		int temp;
        double minus;
        if(w>h) {
        	temp = h;
        	h= w;
        	w = temp;
        }
        minus = h/(double)w;
        
        for (int i = 0; i < w; i++) {
			answer+=Math.floor(minus*i);
		}
                      
        return answer*2;
    }
	
}
