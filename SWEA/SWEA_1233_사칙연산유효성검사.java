package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조건 1. 연산자는 루트 노드 -> 자식 노드가 존재해야 함, 입력받을때 연산자인데 자식 노드가 없다? 안됨
 * 조건 2. 정수가 루트 노드에 오면 안됨, 연산자가 아닌 숫자가 온다? 안됨
 * 정리하자면 입력받을때마다 단일노드인지 아닌지를 체크
 * 단일노드가 아니라면 루트 노드는 연산자가 와야함
 * 단일노드라면 루트 노드는 숫자가 와야 함 -> 숫자가 오는지 확인하기 위해서 Character.isDigit으로 가능!
 * 반대로 확인했을때 둘 중에 하나라도 걸리면 0을 출력하도록
 */
public class SWEA_1233_사칙연산유효성검사 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int num = Integer.parseInt(br.readLine());
			int answer = 1;
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				char c = st.nextToken().charAt(0);
				if (st.hasMoreTokens()) { // 자식 노드가 존재하는데 루트 노드가 숫자라면 0을 출력 -> 단말 노드가 아니라면, 자식이 있다면
					// 아스키코드 상 '0'에서 '9'사이에 있다면 숫자인걸로 간주
					if (Character.isDigit(c)) {
						answer = 0;
					}
				} else { // 단말 노드라면 -> c가 숫자여야함
					if (!Character.isDigit(c)) {
						answer = 0;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
