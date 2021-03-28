package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj_15633fandeath {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] num=new int[n+1];
		for(int i=1;i<=n;i++) {
			if(n%i==0) num[i]=1;
		}
		
		int ans=0;
		for(int i=1;i<=n;i++) {
			if(num[i]==1) {
				ans+=i;
			}
		}
		ans=ans*5-24;
		System.out.println(ans);
	}
	
}
