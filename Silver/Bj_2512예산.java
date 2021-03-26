package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Bj_2512예산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] num=new int[n];
		ArrayList<Integer> pq=new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum=0;
		int max=0;
		for(int i=0;i<n;i++) {
			int m=Integer.parseInt(st.nextToken());
			num[i]=m;
			sum+=m;
		}
		
		Arrays.sort(num);
		
		long ans=0;
		int M=Integer.parseInt(br.readLine());
		long left=0; //보통 left는 0으로 하더라고
		long right=num[n-1];
		while(left<=right) { //이분탐색의 필수 과정....
			long mid=(left+right)/2;
			long s=0;
			for(int i=0;i<n;i++) {
				if(num[i]>=mid) s+=mid;
				else {
					s+=num[i];
				}
			}
			if(s>M) {
				right=mid-1;
			}else {
				left=mid+1;
				ans=Math.max(ans, mid);
			}
		}
		
		
		
		System.out.println(ans);

	}

}
