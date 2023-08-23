package bj.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 조금 헷갈리는 문제.. 
 * '3+8*7-9*2' 이러한 테케의 경우 괄호를 추가할 때 백트래킹을 통해 어느 경우까지 고려가 되는건지
 */
public class BOJ_16637_괄호추가하기 {
	static int n;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		String t = br.readLine();
		for (int i = 0; i < n; i++) {
			// 숫자가 오는 위치
			if (i % 2 == 0) {
				num.add(t.charAt(i) - '0');
			} else {
				// 연산자가 오는 위치
				op.add(t.charAt(i));
			}
		}

		int start = num.get(0);

		dfs(0, start);

		System.out.println(max);
	}

	static void dfs(int idx, int sum) {
		// 기저조건
		if (idx == op.size()) {
			max = Math.max(max, sum);
			return;
		}
		// 괄호를 안 치는 경우
		int res = cal(idx, sum, num.get(idx + 1));
		dfs(idx + 1, res);
		// 괄호를 치는 경우를 백트래킹으로
		if (idx + 1 < op.size()) {
			// 괄호를 친 경우의 수식 결과
			int temp = cal(idx + 1, num.get(idx + 1), num.get(idx + 2));
			// sum과 temp의 위치가 바뀌면 안됨! 왼쪽부터 수식이 진행되기 때문에
			int result = cal(idx, sum, temp);
			dfs(idx + 2, result);
		}
	}

	public static int cal(int op_idx, int a, int b) {
		switch (op.get(op_idx)) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return 1;
	}
}
