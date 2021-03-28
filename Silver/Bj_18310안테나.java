package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Bj_18310안테나 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] num=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			
			num[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int ans=0;
		ans=num[(n-1)/2];
		
		System.out.println(ans);
	}

}
