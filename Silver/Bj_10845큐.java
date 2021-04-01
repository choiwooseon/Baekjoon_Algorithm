package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_10845큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> q= new LinkedList<>();
		
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s=st.nextToken();
			if(s.equals("push")) {
				int x=Integer.parseInt(st.nextToken());
				q.add(x);
			}
			else if(s.equals("pop")) {
				if(q.isEmpty()) {
					sb.append(-1+"\n");
				}
				else{
					sb.append(q.pop()+"\n");
				}
			}
			else if(s.equals("size")) {
				sb.append(q.size()+"\n");
			}
			else if(s.equals("empty")) {
				if(q.isEmpty())
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
			}
			else if(s.equals("front")) {
				if(q.isEmpty())
					sb.append(-1+"\n");
				else {
					int x=q.peek();
					sb.append(x+"\n");
				}
			}
			else if(s.equals("back")) {
				if(q.isEmpty())
					sb.append(-1+"\n");
				else {
					int x=q.peekLast();
					sb.append(x+"\n");
				}
			}
		}
		System.out.println(sb);

	}

}
