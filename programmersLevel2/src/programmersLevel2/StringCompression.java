package programmersLevel2;

public class StringCompression {
	public int solution(String s) {
		int[] arr= new int[s.length()/2+2];
		for (int i = 1; i < arr.length; i++) {
			
			arr[i]=compare(i,s)+s.length()%i;
			
		}
		
        int answer = 1001;
        for(int i=1; i<arr.length; i++) {
        	if(arr[i]<answer) {
//        		System.out.println(i+"  "+arr[i]);
        		answer = arr[i];
        	}
        }
        return answer;
    }

	private int compare(int n,String s) {
		// TODO Auto-generated method stub
		int count=1;
		int length = n;
		boolean jubgment;
		for (int i = 0; i < s.length()/n-1; i++) {
			jubgment = jubg(s.substring(i*n,(i+1)*n),s.substring((i+1)*n,(i+2)*n));
			if(jubgment) {
				count++;
				if(count==2||count==10||count==100) {
					length++;
				}
			}else {
				count = 1;
				length+=n;
			}
		}
		return length;
	}

	private boolean jubg(String s1, String s2) {
		// TODO Auto-generated method stub
		if(s1.equals(s2)) {
			return true;
		}
		return false;
	}
}
