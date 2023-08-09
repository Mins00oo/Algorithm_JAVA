package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 1. 배열에 담아서 풀기 -> 시간초과 발생
 * 2. 이 문제에서의 핵심은 현재값보다 작은 탑 버리도록 하는 것이다 . 
 */
public class G5_2493_탑 {
	static int n;
	static Deque<int[]> stack = new ArrayDeque<>();
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int current = Integer.parseInt(st.nextToken());
			// 현재 높이보다 작은 높이들은 제거하고, 큰 것이 나오면 번호를 출력
			// -> 어차피 밑에 작은ㄱ 것들이 여러 개 있어도 더 큰 기둥이 있다면 밑에 애들은 다 불필요하기 때문임
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= current) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.poll();
			}
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			stack.push(new int[] { i, current });
		}
		System.out.println(sb);

	}
}
