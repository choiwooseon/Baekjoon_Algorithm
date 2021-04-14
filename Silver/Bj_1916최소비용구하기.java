package practice;

import java.util.*;
import java.io.*;

public class Bj_1916최소비용구하기 {

	static int n,m;
	static int[][] map;
	//static ArrayList<int[]> map=new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine()); //도시개수 
		m=Integer.parseInt(br.readLine()); //버스개수
		map=new int[n+1][n+1];
		for(int i=0;i<=n;i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			
			int a=Integer.parseInt(st.nextToken()); 
			int b= Integer.parseInt(st.nextToken()); 
			int w=Integer.parseInt(st.nextToken());
			//map.add(new int[] {a,b,w});
			if(map[a][b]==-1) map[a][b]=w;
			else {
				if(map[a][b]>w) map[a][b]=w;
			}
		}
		
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		
		int[] d=new int[n+1];
		boolean[] visit=new boolean[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start]=0;
		
		
		for(int v=1;v<=n;v++){
			int cost=Integer.MAX_VALUE;
			int idx=1;
			//d가 가장 최소인 정점을 선택하게 됨
			for(int i=1;i<=n;i++) {
				if(!visit[i]&&cost>d[i]) {
					idx=i;
					cost=d[i];
				}
			}
			//선택된 current를 경유지로 아직 처리하지 않은 다른 정점으로의 최소비용을 따져본다
			visit[idx]=true;
			if(idx==end) break;
			
			for(int i=1;i<=n;i++) {
				if(!visit[i]&&map[idx][i]>=0&& d[i]>cost+map[idx][i]) {
					d[i]=cost+map[idx][i];
				}
			}
			
		}
		
		System.out.println(d[end]);

	}

}
