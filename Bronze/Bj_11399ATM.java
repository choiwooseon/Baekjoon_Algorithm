package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj_11399ATM {

	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr=new int[n];
		visited=new boolean[n];
		num=new int[n];
		
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			int x=Integer.parseInt(st.nextToken());
			pq.add(x);
		}
		
		for(int i=0;i<n;i++) {
			num[i]=pq.poll();
		}
		
		int min=Integer.MAX_VALUE;
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				sum+=num[j];
			}
		}
		System.out.println(sum);
		
	}
	
	static boolean visited[];
	static int[] num;
	//static int min=Integer.MAX_VALUE;
	
	/*static void perm(int cnt) {
		if(cnt==n) {
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					sum+=num[j];
					if(min<sum)
						return;
				}
			}
			
			if(min>sum)
				min=sum;

		}
		
		
		for(int i=0;i<n;i++) {
			if(visited[i]==true) continue;
			
			num[cnt]=arr[i];
			visited[i]=true;
			perm(cnt+1);
			visited[i]=false;
		}
	}*/

}
