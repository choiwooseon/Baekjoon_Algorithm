package baekjoon.gold;

import java.util.*;
import java.io.*;

public class Bj_2589보물섬 {

	static int R,C;
	static char[][] map;
	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0;i<R;i++) {
			String str=br.readLine();
			for(int j=0;j<C;j++) {
				char ch=str.charAt(j);
				map[i][j]=ch;
				if(ch=='L') {
					list.add(new int[] {i,j});
				}
			}
		}
		
		int size=list.size();
		int ans=0;
		for(int i=0;i<size;i++) {
			int a=list.get(i)[0];
			int b=list.get(i)[1];
			bfs(a,b,0);
			ans=Math.max(ans, max);
		}
		
		System.out.println(ans);
	}
	
	static int max=0;
	
	static void bfs(int r,int c,int cnt) {
		
		boolean[][] visit=new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();

		visit[r][c]=true;
		q.add(new int[] {r,c,cnt});
		
		while(!q.isEmpty()) {
			int x=q.peek()[0];
			int tc=q.peek()[2];
			int y=q.poll()[1];
			for(int i=0;i<4;i++) {
				int tx=x+deltas[i][0];
				int ty=y+deltas[i][1];

				if(isIn(tx,ty)&&!visit[tx][ty]&&map[tx][ty]=='L') {
					visit[tx][ty]=true;
					q.add(new int[] {tx,ty,tc+1});
					max=Math.max(max, tc+1);
				}
			}
		}
	}

	
	static boolean isIn(int r,int c) {
		return 0<=r&&r<R&&0<=c&&c<C;
	}
}
