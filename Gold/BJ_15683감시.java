package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15683감시 {

	static int n,m;
	static int[][] map;
	static int d1[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	static int d2[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	static ArrayList<int[]>list = new ArrayList<>();
	static int[][] tmpmap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		tmpmap=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int x=Integer.parseInt(st.nextToken());
				map[i][j]=x;
				tmpmap[i][j]=x;
				if(1<=x&&x<=5) {
					list.add(new int[] {i,j,x});
				}
			}
		}
		cctv=new int[list.size()];
		
		duperm(0);
		System.out.println(min);

	}
	
	static boolean isIn(int x,int y) {
		return 0<=x&&x<n&&0<=y&&y<m;
	}

	static int[] cctv;
	static int c=0;
	static int min=Integer.MAX_VALUE;
	//중복순열
	static void duperm(int cnt) {
		if(cnt==list.size()) {
			c=0;
			watch();
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==0)
						c++;
				}
			}
			min=Math.min(min, c);
			
			for(int i=0;i<n;i++) {
				map[i]=tmpmap[i].clone();
			}

			return;
		}
		
		for(int i=0;i<4;i++) {
			cctv[cnt]=i;
			duperm(cnt+1);
		}
	}
	
	//cctv감시 범위 체크
	static void watch() {
		int size=list.size();
		for(int i=0;i<size;i++) {
			int tx=list.get(i)[0];
			int ty=list.get(i)[1];
			//각cctv의 위치 확인
			/////1번 cctv
			if(list.get(i)[2]==1) {
				if(cctv[i]==0) {
					for(int j=1;;j++) {
						tx-=1;
						if(isIn(tx,ty)&&map[tx][ty]==0) {
							map[tx][ty]=-1;
						}
						else if(!isIn(tx,ty)||isIn(tx,ty)&&map[tx][ty]==6) break;
						else if(isIn(tx,ty)&&1<=map[tx][ty]&&map[tx][ty]<=5) continue;
						
					}
				}
				else if(cctv[i]==1) { //하
					for(int j=1;;j++) {
						tx+=1;
						if(isIn(tx,ty)&&map[tx][ty]==0) {
							map[tx][ty]=-1;
						}
						else if(!isIn(tx,ty)||isIn(tx,ty)&&map[tx][ty]==6) break;
						else if(isIn(tx,ty)&&1<=map[tx][ty]&&map[tx][ty]<=5) continue;
						
					}
				}
				else if(cctv[i]==2) {
					for(int j=1;;j++) {
						ty-=1;
						if(isIn(tx,ty)&&map[tx][ty]==0) {
							map[tx][ty]=-1;
						}
						else if(!isIn(tx,ty)||isIn(tx,ty)&&map[tx][ty]==6) break;
						else if(isIn(tx,ty)&&1<=map[tx][ty]&&map[tx][ty]<=5) continue;
						
					}
				}
				else if(cctv[i]==3) {
					for(int j=1;;j++) {
						ty+=1;
						if(isIn(tx,ty)&&map[tx][ty]==0) {
							map[tx][ty]=-1;
						}
						else if(!isIn(tx,ty)||isIn(tx,ty)&&map[tx][ty]==6) break;
						else if(isIn(tx,ty)&&1<=map[tx][ty]&&map[tx][ty]<=5) continue;
						
					}
				}
			}
			//////////2번 cctv 
			else if(list.get(i)[2]==2) {
				if(cctv[i]==0||cctv[i]==2) {
					for(int j=ty;j<m;j++) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=ty;j>=0;j--) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
				}
				else if(cctv[i]==1||cctv[i]==3) {
					for(int j=tx;j<n;j++) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
					for(int j=tx;j>=0;j--) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
				}
				
			}
			//////////////3번//////////////
			else if(list.get(i)[2]==3) {
				if(cctv[i]==0) {
					for(int j=ty;j<m;j++) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=tx;j>=0;j--) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
				}
				else if(cctv[i]==1) {
					for(int j=ty;j<m;j++) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=tx;j<n;j++) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
				}
				else if(cctv[i]==2) {
					for(int j=ty;j>=0;j--) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=tx;j<n;j++) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
				}
				else if(cctv[i]==3) {
					for(int j=ty;j>=0;j--) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=tx;j>=0;j--) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
				}
			}
			////////4번 cctv////////////
			else if(list.get(i)[2]==4) {
				if(cctv[i]==0) {
					for(int j=ty;j<m;j++) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=ty;j>=0;j--) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=tx;j>=0;j--) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
				}
				else if(cctv[i]==1) {
					for(int j=ty;j<m;j++) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=tx;j<n;j++) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
					for(int j=tx;j>=0;j--) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
				}
				else if(cctv[i]==2) {
					for(int j=ty;j<m;j++) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=tx;j<n;j++) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
					for(int j=ty;j>=0;j--) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
				}
				else if(cctv[i]==3) {
					for(int j=tx;j<n;j++) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
					for(int j=ty;j>=0;j--) {
						if(map[tx][j]==6) break;
						else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
						else {
							map[tx][j]=-1;
						}
					}
					for(int j=tx;j>=0;j--) {
						if(map[j][ty]==6) break;
						else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
						else {
							map[j][ty]=-1;
						}
					}
				}
			}
			///////cctv 5번////////////
			else if(list.get(i)[2]==5) {
				for(int j=tx;j<n;j++) {
					if(map[j][ty]==6) break;
					else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
					else {
						map[j][ty]=-1;
					}
				}
				for(int j=ty;j>=0;j--) {
					if(map[tx][j]==6) break;
					else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
					else {
						map[tx][j]=-1;
					}
				}
				for(int j=tx;j>=0;j--) {
					if(map[j][ty]==6) break;
					else if(1<=map[j][ty]&&map[j][ty]<=5) continue;
					else {
						map[j][ty]=-1;
					}
				}
				for(int j=ty;j<m;j++) {
					if(map[tx][j]==6) break;
					else if(1<=map[tx][j]&&map[tx][j]<=5) continue;
					else {
						map[tx][j]=-1;
					}
				}
			}
		}
	}

}
