package programmers.Lv2;

import java.util.Stack;

public class PGS_짝지어_제거하기 {
	
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);   
            }
        }
        
        answer = (stack.isEmpty()) ? 1 : 0;
        return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(new PGS_짝지어_제거하기().solution("baabaa"));
	}
}
