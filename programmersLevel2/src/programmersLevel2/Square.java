package programmersLevel2;

public class Square {
	public int solution(int [][]board)
    {
        int row=0;
        int a;
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]==1) {
					a=seed(i,j,board,1);

					if(row < a) {
						row = a;
						i+=row;
						j+=row;
					}

				}
			}
		}
        
        return row*row;
    }
	
	public int seed(int a, int b, int[][] board,int count) {
		
		boolean tf=true;
		if(a>=board.length-1||b>=board[a].length-1) {
			
			return count;
		}
		else {
			if(board[a+1][b]==1&&board[a][b+1]==1&&board[a+1][b+1]==1){
	            for(int i = 1;i<count;i++) {
					if(board[a-i][b+1]==1&&board[a+1][b-i]==1) {
						tf=true;
					}else {
						tf=false;
						break;
					}
	            }
	        }else
				tf = false;
			
			if(tf) {
				count++;
				count=seed(a+1,b+1,board,count);
			}

			return count;
		}
	}
}
