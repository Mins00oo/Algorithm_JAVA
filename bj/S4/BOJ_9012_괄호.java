package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
	static int T;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		outer: for (int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (c == '(') {
					stack.push('(');
				} else if (stack.isEmpty()) { // 더 이상 스택에 아무것도 없어서 pop이 안될수가 있기 때문에
					sb.append("NO").append("\n");
					continue outer;
				} else { // 닫는 괄호가 오기 때문에 여는 괄호가 있는 것을 pop해주고
					stack.pop();
				}
			}
//			for (Character character : stack) {
//				System.out.println(character);
//			}
			if (stack.isEmpty()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}

		System.out.println(sb);
	}
}
