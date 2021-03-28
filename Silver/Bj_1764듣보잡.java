package baekjoon.silver;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Bj_1764듣보잡 {

	static int n,m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		String[] not=new String[n+m];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n+m;i++) {
			not[i]=br.readLine();
		}
		Arrays.sort(not);
		
		int cnt=0;
		for(int i=0;i<n+m-1;i++) {
			if(not[i].equals(not[i+1])) {
				cnt++;
				sb.append(not[i]+"\n");
				i++;
			}
		}
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append(cnt+"\n");
		sb1.append(sb);
		System.out.println(sb1);

	}

}
