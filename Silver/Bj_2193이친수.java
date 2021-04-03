package timeattack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj_2193이친수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int size=(int)Math.pow(2, n);
		
		int cnt=0;
		
		for(int i=0;i<size;i++) {
			int idx=i;
			
			int tc=0;
			int flag=0;
			for(int j=n-1;j>=1;j--) {
				if(idx%2==1) {
					tc++;
					if(tc==2) {
						flag=1;
						break;
					}
				}
				else {
					tc=0;
				}
				idx/=2;
			}
			if(idx==1) flag=1;
			
			if(flag==0)
				cnt++;
			
		}
		
	
		
		System.out.println(cnt);

	}

}
