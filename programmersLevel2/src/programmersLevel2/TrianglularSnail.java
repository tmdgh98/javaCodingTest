package programmersLevel2;

public class TrianglularSnail {
	private int[][] arr;
	private int num=1;
	private int start = 0;
	private int last = 0;
	public int[] solution(int n) {
        arr = new int[n][];
        for (int i = 0; i < n; i++) {
			arr[i] = new int[i+1];
		}
        down(0,n-1);
        int sum =0;
        for (int i = 0; i <= n; i++) {
			sum += i;
		}
 
        int[] answer = new int[sum];
        int idx=0;
        for (int[] a : arr) {
			for(int b : a) {
				answer[idx] = b;
				idx++;
			}
		}
        return answer;
    }
	private void down(int up, int down) {
		
		if(up<=down) {
			for (int i = up; i <= down; i++) {
				arr[i][start]=num++;
			}
			start++;
			horizontal(down);
		}
	}
	private void horizontal(int down) {
		if(start<arr[down].length-last) {
			for (int i = start; i < arr[down].length-last; i++) {
				arr[down][i]=num++;
			}
//			System.out.println(arr.length-(n)+" "+(n-1));
			up(arr.length-(down),down-1);
		}
	}
	private void up(int up, int down) {
		if(down>=up) {
			int i = down;
			while (i>=up&&arr[i][arr[i].length-last-1]==0) {
				arr[i][arr[i].length-last-1]=num++;
				i--;
			}
			last++;
			down(i+2,down);
		}
	}
}
