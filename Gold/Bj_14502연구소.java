package baekjoon.gold;

import java.lang.*;
import java.io.*;
import java.util.*;

public class Bj_14502연구소 {

	static ArrayList<int[]> list= new ArrayList<>();
	static int n,m;
	static int[][] map;
	static int[][] tempmap;
	static ArrayList<int[]> twolist=new ArrayList<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		tempmap=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int x=Integer.parseInt(st.nextToken());
				map[i][j]=x;
				tempmap[i][j]=x;
				if(x==0) {
					list.add(new int[] {i,j});
				}
				if(x==2) {
					twolist.add(new int[] {i,j});
				}
			}
		}
		
		
		
		visit=new boolean[list.size()];
		comb(0);
		System.out.println(max);

	}
	
	static boolean isIn(int r,int c) {
		return 0<=r&&r<n&&0<=c&&c<m;
	}

	
	static boolean[] visit;
	static int[] num=new int[3];
	static boolean[][] v; //dfs를 위한 visit 함수
	static int max=0;
	
	static void comb(int cnt) {
		if(cnt==3) {
			v=new boolean[n][m]; //dfs를 위한 visit 함수
			int countzero=0;
			
			//벽 세울 수 있는 조합대로 벽 세워줌 
			setnum(1);
			
			for(int i=0;i<twolist.size();i++) {
				int x=twolist.get(i)[0];
				int y=twolist.get(i)[1];
				bfs(x,y);
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==0) countzero++;
				}
			}
			
			max=Math.max(max, countzero);
			for(int k=0;k<n;k++) {
				map[k]=tempmap[k].clone();
			}
			return;
		}
		
		int size=list.size();
		for(int i=0;i<size;i++) {
			if(visit[i]==true) continue;
			
			visit[i]=true;
			num[cnt]=i;
			comb(cnt+1);
			visit[i]=false;
		}
	}
	
	static void bfs(int r,int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		v[r][c]=true;
		
		while(!q.isEmpty()) {
			
			int x=q.peek()[0];
			int y=q.poll()[1];
			for(int i=0;i<4;i++) {
				int tx=x+deltas[i][0];
				int ty=y+deltas[i][1];
				
				if(isIn(tx,ty)&&!v[tx][ty]&&map[tx][ty]!=1) {
					v[tx][ty]=true;
					map[tx][ty]=2;
					q.add(new int[] {tx,ty});
				}
			}
		}
	}
	
	//1로 바꿔주는 함수
	static void setnum(int n) {
		for(int i=0;i<3;i++) {
			int idx=num[i];
			int x=list.get(idx)[0];
			int y=list.get(idx)[1];
			map[x][y]=n;
		}
	}
	
	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	
	
}
