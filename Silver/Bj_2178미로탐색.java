package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 28.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution 최소거리 -> BFS 그리고 char배열로 받았기때문에 비교할떄 주의하기
 */

public class Bj_2178미로탐색 {

	static int N,M;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N+1][M+1];
		visited=new boolean[N+1][M+1];
		
		
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j+1]=str.charAt(j);
			}
		}
		
		visited[1][1]=true;
		bfs(1,1,1);
		System.out.println(ans);
	}

	static boolean visited[][];
	static int deltas[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	static int ans=0;
	
	static void bfs(int r, int c,int cnt) {
		Queue<int[]> q=new LinkedList<>();
		
		q.add(new int[] {r,c,cnt});
		visited[r][c]=true;
		while(!q.isEmpty()) {
			int x=q.peek()[0];
			int y=q.peek()[1];
			int t=q.poll()[2];
			if(x==N&&y==M) {
				ans=t;
				return;
				
			}
			
			for(int i=0;i<4;i++) {
				int dx=x+deltas[i][0];
				int dy=y+deltas[i][1];
			
				if(isIn(dx,dy)&&visited[dx][dy]==false&&map[dx][dy]=='1') {
					
					visited[dx][dy]=true;
					q.add(new int[] {dx,dy,t+1});
				}
			}
			
		}
		
	
	}
	
	static boolean isIn(int r,int c) {
		return 1<=r&&r<=N&&1<=c&&c<=M;
	}
}
