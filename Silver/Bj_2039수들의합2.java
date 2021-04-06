package workshop;

import java.util.*;
import java.io.*;

public class Bj_2039수들의합2 {

	static int n,m,cnt;
	static int[] array;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		array=new int[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		
		int sum=0;
		for(int i=0;i<n;i++) {
			sum=0;
			int idx=i;
			while(sum<m) {
				sum+=array[idx];
				if(idx+1<n)
					idx++;
				else break;
			}
			if(sum==m) cnt++;
		}
		
		System.out.println(cnt);

	}
	
	

}
