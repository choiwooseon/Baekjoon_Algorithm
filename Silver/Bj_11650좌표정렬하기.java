package baekjoon.silver;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Bj_11650좌표정렬하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> list=new ArrayList<>();
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			list.add(new int[] {a,b});
		}
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0])
					return Integer.compare(o1[1], o2[1]);
				else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
			
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(list.get(i)[0]+" "+list.get(i)[1]+"\n");
		}
		
		System.out.println(sb);
	}

}
