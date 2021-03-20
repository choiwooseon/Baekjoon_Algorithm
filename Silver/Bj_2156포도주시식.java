package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj_2156포도주시식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int[] alcohol=new int[n+1];
		int[] dp=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			alcohol[i]=Integer.parseInt(br.readLine());
		}
		
		int max=0;
		dp[1]=alcohol[1];
		if(n>=2) dp[2]=alcohol[1]+alcohol[2];
		
		
		
		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-2], dp[i-3]+alcohol[i-1])+alcohol[i];
			dp[i]=Math.max(dp[i], dp[i-1]);
		}
		
		System.out.println(dp[n]);
		
	}

}
