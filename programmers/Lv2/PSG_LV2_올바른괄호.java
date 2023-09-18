package programmers.Lv2;

import java.util.Stack;

public class PSG_LV2_올바른괄호 {
	
	public static void main(String[] args) {
		System.out.println(solution("()()"));
	}
	
	static boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
        
        return stack.isEmpty();
	}
}
