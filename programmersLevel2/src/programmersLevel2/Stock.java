package programmersLevel2;

public class Stock {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int num;
        int count;
        for (int i = 0; i < prices.length; i++) {
			num = prices[i];
			count = 0;
        	for (int j = i+1; j < prices.length; j++) {
        		count++;
        		if(num>prices[j]) {
        			break;
				}
			}
        	answer[i] = count;
		}
        return answer;
    }
}
