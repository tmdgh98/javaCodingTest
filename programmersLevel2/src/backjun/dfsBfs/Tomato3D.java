package backjun.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato3D {
	private static int[][][] tomato;
	private static boolean[][][] visit;
	private static int[][][] cnt;
	private static Queue<int[]> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		tomato = new int[x][y][z];
		visit = new boolean[x][y][z];
		cnt = new int[x][y][z];
		que = new LinkedList<int[]>();
		int xi=0;
		int zi=-1;
		for (int iz = 0; iz < x*z; iz++) {
			st = new StringTokenizer(br.readLine());
			if(iz%x==0) {
				xi=0;
				zi++;
			}
			for (int j = 0; j < y; j++) {
				tomato[xi][j][zi] =Integer.parseInt(st.nextToken());
				if(tomato[xi][j][zi]==1) {
					int[] next = {xi,j,zi,1};
					que.offer(next);
				}
			}
			xi++;
		}
		
		tomato();
		int max = 0;
		loop :
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int j2 = 0; j2 < z; j2++) {
					if(tomato[i][j][j2]!=-1&&cnt[i][j][j2]==0) {
						max = -1;
						break loop;
					}
					if(cnt[i][j][j2]>max) {
						max = cnt[i][j][j2];
					}
				}
			}
		}
		
		System.out.println(max==-1?-1:max-1);
	}
	private static void tomato() {
		// TODO Auto-generated method stub
		while(!que.isEmpty()) {
			int[] q= que.poll();
			int x = q[0];
			int y = q[1];
			int z = q[2];
			int c = q[3];
			if(visit[x][y][z]) continue;
			
			visit[x][y][z]=true;
			
			if(tomato[x][y][z]!=-1) {
				if(cnt[x][y][z]==0) {
					cnt[x][y][z]=c;
				}else {
					cnt[x][y][z] = Math.min(c, cnt[x][y][z]);
				}
				
				if(x>0) {
					int[] next = {x-1,y,z,c+1};
					que.offer(next);
				}
				if(y>0) {
					int[] next = {x,y-1,z,c+1};
					que.offer(next);
				}
				if(z>0) {
					int[] next = {x,y,z-1,c+1};
					que.offer(next);
				}
				if(x<tomato.length-1) {
					int[] next = {x+1,y,z,c+1};
					que.offer(next);
				}
				if(y<tomato[x].length-1) {
					int[] next = {x,y+1,z,c+1};
					que.offer(next);
				}
				if(z<tomato[x][y].length-1) {
					int[] next = {x,y,z+1,c+1};
					que.offer(next);
				}
			}
		}
	}
}
