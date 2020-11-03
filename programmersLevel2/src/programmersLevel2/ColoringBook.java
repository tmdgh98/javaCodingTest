package programmersLevel2;

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
				if(arr[i][j]==0||picture[i][j]!=0) {
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
		if(0<=r&&r<row&&0<=c&&c<column) {	
			if(picture[r][c]==n) {
				sizeOfOneArea++;
				arr[r][c]=1;
				find(r-1,c,picture,n);
				find(r,c-1,picture,n);
				find(r+1,c,picture,n);
				find(r,c+1,picture,n);
			}
		}
		
	
	}
}
