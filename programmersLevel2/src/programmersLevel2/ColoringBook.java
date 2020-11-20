package programmersLevel2;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
	private int row;
	private int column;
	private int numberOfArea = 0;
	private int maxSizeOfOneArea = 0;
	private int sizeOfOneArea = 0;
	private int[][] arr;
	public int[] solution(int m, int n, int[][] picture) {
        
        int[] answer = new int[2];
        
        arr = new int[m][n];
        row = m;
        column=n;
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]==0&&picture[i][j]!=0) {
					numberOfArea++;
					sizeOfOneArea = 0;
					find(i,j,picture,picture[i][j]);
					if(maxSizeOfOneArea<sizeOfOneArea) {
						maxSizeOfOneArea=sizeOfOneArea;
					}
				}
			}
		}
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	private void find(int r, int c, int[][] picture,int n) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c});
		while(!que.isEmpty()) {
			int[] q = que.poll();
			r=q[0];
			c=q[1];
			if(picture[r][c]==n) {
				if(arr[r][c]==1) continue;
				arr[r][c]=1;
				sizeOfOneArea++;
				
				if(r>0) que.offer(new int[] {r-1,c});
				if(c>0) que.offer(new int[] {r,c-1});
				if(r<picture.length-1) que.offer(new int[] {r+1,c});
				if(c<picture[r].length-1) que.offer(new int[] {r,c+1});
			}
			
		}
		
	
	}
}
