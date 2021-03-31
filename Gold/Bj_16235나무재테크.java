package baekjoon.gold;

import java.lang.*;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.io.*;

public class Bj_16235나무재테크 {

	static int n,m,k;
	static tree[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); //땅 크기
		m=Integer.parseInt(st.nextToken()); // 나무 개수
		k=Integer.parseInt(st.nextToken()); // k 년 후 
		map=new tree[n+1][n+1];
		int[][] A=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) { //양분
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				LinkedList<Integer> age = new LinkedList<>();
				//PriorityQueue<Integer> age = new PriorityQueue<>();
				int n=Integer.parseInt(st.nextToken());
				map[i][j]=new tree(5,age);
				A[i][j]=n;
			}
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			
			map[r][c].age.add(a);
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				Collections.sort(map[i][j].age);
			}
		}
		
		
		//k년동안의 변화
		for(int t=0;t<k;t++) {
			//봄
			int[][] summer=new int[n+1][n+1];
			for(int i=1;i<=n;i++) { //양분
				for(int j=1;j<=n;j++) {
					int size=map[i][j].age.size();
					for(int k=0;k<size;k++) {
						int a=map[i][j].age.poll();
						int n=map[i][j].nutri;
						if(n>=a) { //영양분 제공할 수 있으면
							n-=a;
							map[i][j].nutri=n;
							map[i][j].age.add(a+1);
						}
						else {
							summer[i][j]+=a/2;
						}
					}
				}
			}
			//여름
			for(int i=1;i<=n;i++) { //양분
				for(int j=1;j<=n;j++) {
					map[i][j].nutri+=summer[i][j];
				}
			}
			
			//가을
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					int s=map[i][j].age.size();
					for(int k=0;k<s;k++) {
						int a=map[i][j].age.poll();
						if(a%5==0) {
							for(int d=0;d<8;d++) {
								int tx=i+deltas[d][0];
								int ty=j+deltas[d][1];
								if(isIn(tx,ty)) {
									map[tx][ty].age.add(1);
								}
							}
						}
						map[i][j].age.add(a);
					}
				}
			}
			//겨울
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					map[i][j].nutri+=A[i][j];
				}
			}
			
			//정렬
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					Collections.sort(map[i][j].age);
				}
			}
		}
		
		int cnt=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				cnt+=map[i][j].age.size();
			}
		}
		
		System.out.println(cnt);
	}
	
	static class tree{
		int nutri;
		LinkedList<Integer> age = new LinkedList<>();
		tree(int nutri,LinkedList<Integer> age){
			this.nutri=nutri;
			this.age=age;
		}
	}

	static int[][] deltas= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	static boolean isIn(int r,int c) {
		return 1<=r&&r<=n&&1<=c&&c<=n;
	}
}
