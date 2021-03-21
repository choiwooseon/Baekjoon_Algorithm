package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 10.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution for루프 돌때의 범위를 생각해주자!
 */


public class Bj_5567결혼식 {

	static int n,m;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		visit=new boolean[n+1];
		map=new int[n+1][n+1];
		m=Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			map[a][b]=map[b][a]=1;
		}
		
		visit[1]=true;
		bfs(1); //1번인 상근이부터 시작
		System.out.println(ans);
	}

	static int ans=0;
	
	static void bfs(int idx) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {idx,0});
		visit[idx]=true;
		while(!q.isEmpty()) {
			int x=q.peek()[0]; //친구의 번호
			int cnt=q.poll()[1]; //상근이와의 관계
			
			for(int i=1;i<=n;i++) {
				if(!visit[i]&&map[x][i]==1) {
					visit[i]=true;
					if(cnt<2) { //상근이와의 관계가 2 미만일때만
						ans++; //탐색 지속
						q.add(new int[] {i,cnt+1});
					}
				}
			
			}
		}
	}
	
}
