package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_1456거의소수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long s=Long.parseLong(st.nextToken());		
		long e=Long.parseLong(st.nextToken());
		
		boolean[] num=new boolean[10000001];
		num[1]=true;
		for(int i=2;i<=10000000;i++) {
			for(int j=i+i;j<=10000000;j+=i) {
				num[j]=true; //소수가 아닐 때 true 
			}
		}
		
		int cnt=0;
		for(int i=2;i<=Math.sqrt(e);i++) {
			if(!num[i]) {//소수면
				long tmp=i;
				while(tmp<=e) { //소수의 n제곱을 찾자
					if(tmp>=e/i) break;
					tmp*=i;
					if(tmp>=s)
						cnt++;
				}
			}
		}
	
		System.out.println(cnt);
	}
	

}
