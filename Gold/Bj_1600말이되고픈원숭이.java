package baekjoon.re;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Bj_1600말이되고픈원숭이 {
	
	static int k,w,h;
	static int[][] map;
	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
	static int[][] cnt;
	
	static class INFO {
		int x,y,c,dis;
		INFO(int x,int y,int c,int dis){
			this.x=x;
			this.y=y;
			this.c=c;
			this.dis=dis;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		map=new int[h][w];
		cnt=new int[h][w];
		
		
		for(int i=0;i<h;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
			Arrays.fill(cnt[i], 99);
		}
		
		bfs(0,0,0,0);
		System.out.println(ans);

	}
	
	static boolean isIn(int r,int c) {
		return 0<=r&&r<h&&0<=c&&c<w;
	}
	
	static boolean visit[][];
	static int ans=0;
	
	static void bfs(int i,int j,int count,int d) {
		Queue<INFO> q = new LinkedList<>();
		q.add(new INFO(i,j,count,d));
		
		while(!q.isEmpty()) {
			int x=q.peek().x;
			int y=q.peek().y;
			int c=q.peek().c;
			int dis=q.poll().dis;
			
			if(x==h-1&&y==w-1) {
				ans=dis;
				return;
			}
			
			if(c<k) {
				for(int idx=4;idx<12;idx++) {
					int nx=x+deltas[idx][0];
					int ny=y+deltas[idx][1];
					if(!isIn(nx,ny)||map[nx][ny]==1||cnt[nx][ny]<=c+1) continue;
					cnt[nx][ny]=c+1;
					q.offer(new INFO(nx,ny,c+1,dis+1));
				}
			}
			
			for(int idx=0;idx<4;idx++) {
				int nx=x+deltas[idx][0];
				int ny=y+deltas[idx][1];
				if(!isIn(nx,ny)||map[nx][ny]==1||cnt[nx][ny]<=c) continue;
				cnt[nx][ny]=c;
				q.offer(new INFO(nx,ny,c,dis+1));
			}
		}
		
		if(ans==0) {
			ans=-1;
		}
		
	}

}
