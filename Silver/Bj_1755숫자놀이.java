import java.util.*;
import java.io.*;
import java.lang.*;

public class Algo1_서울_12반_최우선 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken()); //시작 정수
		int n=Integer.parseInt(st.nextToken()); //끝 정수
		ArrayList<Num> list=new ArrayList<>(); //숫자의 정보를 가지고있는 클래스를 정렬하기 위한 리스트
		
		
		for(int i=m;i<=n;i++) {
			String str="";
			if(i>=10) {
				int a=i/10; //십의 자리
				int b=i%10; //일의 자리
				
				str+=eng(a); //숫자를 string으로 변경
				str+=" ";
				str+=eng(b);
				
				list.add(new Num(str,i)); //list에 추가해주기
			}
			else {
				str=eng(i); //숫자를 String으로 정렬
				list.add(new Num(str,i)); //list에 추가해주기
			}
			
			
			
		}
 
		
		Collections.sort(list); //String으로 정렬하기
		
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		//10개씩 출력하기 위한 for문
		for(int i=0;i<list.size();i++) {
			if(cnt==10) { //한줄에 10개가 됐을 때
				sb.append("\n"); //줄바꾸기
				cnt=0; //cnt초기화
				sb.append(list.get(i).number+" "); //이어서 출력
				cnt++; //cnt올려주기
			}
			else {
				sb.append(list.get(i).number+" "); //숫자 출력
				cnt++; //cnt+1해주기
			}
		}
		System.out.println(sb);
		
	}
	
	static class Num implements Comparable<Num>{ //숫자의 정보를 담기 위한 class
		String num1; //숫자를 String으로 받기 위함
		int number; // 나중에 출력은 숫자로 해주기 위한 변수
		
		Num(String num1,int number) { //객체 생성
			this.num1=num1;
			this.number=number;
		}

		@Override
		public int compareTo(Num o) { //string으로 정렬하기 위해서
			return (o.num1.compareTo(this.num1))*-1;
		}


	}
	
	static String eng(int a) { //숫자를 String으로 바꿔주는 함수
		if(a==0) {
			return "zero";
		}
		else if(a==1) {
			return "one";

		}
		else if(a==2) {
			return "two";

		}
		else if(a==3) {
			return "three";

		}
		else if(a==4) {
			return "four";

		}
		else if(a==5) {
			return "five";

		}
		else if(a==6) {
			return "six";

		}
		else if(a==7) {
			return "seven";

		}
		else if(a==8) {
			return "eight";

		}
		else {
			return "nine";
		}
	}

	
}
