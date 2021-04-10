package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_18428감시피하기 {

	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int n;
	static String[][] map;
	static String[][] tmp;
	static ArrayList<int[]> teacherlist=new ArrayList<>();
	static ArrayList<int[]> X = new ArrayList<>();

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		map=new String[n][n];
	
		

		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				String s=st.nextToken();
				if(s.equals("T")) {
					teacherlist.add(new int[] {i,j});
				}
				else if(s.equals("X")) {
					X.add(new int[] {i,j});
				}
				map[i][j]=s;

			}
		}
		
		perm(0,0);
		System.out.println(ans);
		
		
	}
	
	static int[] obstacle=new int[3];
	static String ans;
	//장애물 놓을 3개 선택 (수열)
	static void perm(int cnt,int start) {
		if(cnt==3) {
			for(int i=0;i<3;i++) {
				int idx=obstacle[i];
				int x=X.get(idx)[0];
				int y=X.get(idx)[1];
				
				map[x][y]="O";
				
			}
			
			
			if(dfs()) { //감시 피하기 성공
				System.out.println("YES");
				System.exit(0);
			}
			
			for(int j=0;j<3;j++) { //장애물 초기화
				int idx=obstacle[j];
				int x=X.get(idx)[0];
				int y=X.get(idx)[1];
					
				map[x][y]="X";
			}
			
			ans="NO";
			return;
		}
		
		for(int i=start;i<X.size();i++) {
			obstacle[cnt]=i;
			perm(cnt+1,i+1);
		}
		
	}
	

	static boolean dfs() {
		for(int k=0;k<teacherlist.size();k++) {
			int x=teacherlist.get(k)[0];
			int y=teacherlist.get(k)[1];
			for(int i=0;i<4;i++) {
				int tx=x+deltas[i][0];
				int ty=y+deltas[i][1];
				
				while(isIn(tx,ty)) {
					if(map[tx][ty].equals("X")) {
						tx+=deltas[i][0];
						ty+=deltas[i][1];
					}
					else if(map[tx][ty].equals("S")) { //학생을 만나면 true-> 실패
						return false;
					}
					else if(map[tx][ty].equals("O")) {
						break;
					}
					else {
						tx+=deltas[i][0];
						ty+=deltas[i][1];
					}
					
				}
				
			}
		}
		return true; //감시 피하기 성공
	}
	
	static boolean isIn(int r,int c) {
		return 0<=r&&r<n&&0<=c&&c<n;
	}
	
	
}

