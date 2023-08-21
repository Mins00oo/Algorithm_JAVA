package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10773_제로 {
	static int K, sum;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			
			if (s == 0) {
				stack.pop();
			} else {
				stack.push(s);
			}
		}
		
		for (int num : stack) {
			sum += num;
		}
		
		System.out.println(sum);
	}
}
