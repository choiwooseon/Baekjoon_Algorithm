package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Bj_1463_1로만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(br.readLine());
		int[] num=new int[x+1];
		
		num[0]=0;
		num[1]=0;
		if (x>1) num[2]=1;
	    if (x>2) num[3]=1;
	    
		for(int i=4;i<=x;i++) {
			if(i%3==0) {
                num[i]=Math.min(num[i/3]+1, num[i-1]+1);
            }
            if(i%2==0) {
                
                num[i]=Math.min(num[i/2]+1, num[i-1]+1);
            }
            if(i%2==0&&i%3==0) {
                num[i]=Math.min(num[i/2]+1, num[i/3]+1);
                num[i]=Math.min(num[i], num[i-1]+1);
            }
            if(i%2!=0||i%3!=0) {
                num[i]=Math.min(num[i], num[i-1]+1);
            }

		}
		
		System.out.println(num[x]);
	}

}
