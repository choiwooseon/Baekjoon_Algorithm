package workshop;

import java.io.*;
import java.util.*;

public class Bj_10825국영수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str=null;
		int kor=0;
		int eng=0;
		int math=0;
		
		int n=Integer.parseInt(br.readLine());
		STUDENT[] stu=new STUDENT[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			str=st.nextToken();
			kor=Integer.parseInt(st.nextToken());
			eng=Integer.parseInt(st.nextToken());
			math=Integer.parseInt(st.nextToken());
			
			stu[i]=new STUDENT(str, kor, eng, math);
		}
		
		Arrays.sort(stu);
		
		for(int i=0;i<n;i++) {
			sb.append(stu[i].name+"\n");	
		}
		
		System.out.println(sb);
		

	}
	
	static class STUDENT implements Comparable<STUDENT>  {
		String name;
		int kor;
		int eng;
		int math;
	
		//객체 생성할때 new 없음
		STUDENT(String name,int kor, int eng, int math) {
			this.name=name;
			this.kor=kor;
			this.eng=eng;
			this.math=math;
		}

		@Override
		public int compareTo(STUDENT o) {
			if(this.kor!=o.kor)
				return Integer.compare(o.kor, this.kor);
			else{
				if(this.eng!=o.eng)
					return Integer.compare(this.eng, o.eng);
				else {
					if(this.math!=o.math)
						return Integer.compare(o.math, this.math);
					else {
						return this.name.compareTo(o.name);
					}
				}
			}
		}
		
	}

}
