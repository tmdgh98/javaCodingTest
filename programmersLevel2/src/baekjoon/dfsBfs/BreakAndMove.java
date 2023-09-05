//N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 
//1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 
//이때 최단 경로로 이동하려 한다. 
//최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 
//이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
//
//만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 
//벽을 한 개 까지 부수고 이동하여도 된다.
//
//맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 
//다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.
//
//출력
//첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

package baekjoon.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakAndMove {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int xn = Integer.parseInt(st.nextToken());
		int yn = Integer.parseInt(st.nextToken());
		String[][] wall = new String[xn][yn];
		boolean [][][] visited = new boolean[xn][yn][2];
		
		for (int i = 0; i < xn; i++) {
			wall[i] = br.readLine().split("");
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0,1,0});
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];
			int count = q[2];
			int bk = q[3];
			
			if(visited[x][y][bk]) continue;
			
			visited[x][y][bk] = true;
			
			if(x==wall.length-1&&y==wall[x].length-1) {
				sb.append(count);
				break;
			}
			if(wall[x][y].equals("1")&&bk==1) continue;
			
			if(wall[x][y].equals("1")&&bk==0) bk=1;
			
			if(x>0) queue.offer(new int[] {x-1,y,count+1,bk});
			if(y>0) queue.offer(new int[] {x,y-1,count+1,bk});
			if(x<wall.length-1) queue.offer(new int[] {x+1,y,count+1,bk});
			if(y<wall[x].length-1) queue.offer(new int[] {x,y+1,count+1,bk});
			
		}
		
		if(sb.length()==0) {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}

}
