package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj_10814나이순정렬 {

	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		ArrayList<member> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age=Integer.parseInt(st.nextToken());
			String name=st.nextToken();
			
			list.add(new member(age,name,i));
			
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i).age+" "+list.get(i).name+"\n");
		}
		System.out.println(sb);
	}

	static class member implements Comparable<member>{
		int age;
		String name;
		int idx;
		
		member(int age,String name,int idx){
			this.age=age;
			this.name=name;
			this.idx=idx;
		}

		@Override
		public int compareTo(member o) {
			if(this.age==o.age)
				return Integer.compare(this.idx, o.idx);
			else
				return Integer.compare(this.age, o.age);
		}
		
		
	}
	
}
