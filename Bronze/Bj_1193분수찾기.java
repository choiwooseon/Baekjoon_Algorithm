package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj_1193분수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x=Integer.parseInt(br.readLine());
		
		int sum=0;
		int i=1;
		while(sum<x) {
			sum+=i;
			i++;
		}
		--i;
		sum-=i;
		if(i%2==0) {
			System.out.println((x-sum)+"/"+(i+1-(x-sum)));
		}
		else {
			System.out.println((i+1-(x-sum))+"/"+(x-sum));
		}
	}

}
