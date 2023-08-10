package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1218_괄호짝짓기 {
	static int[] str_count;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			str_count = new int[8];
			int len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			Queue<Character> queue = new ArrayDeque<>();
			for (int i = 0; i < len; i++) {
				queue.offer(s.charAt(i));
			}

			while (!queue.isEmpty()) {
				Character poll = queue.poll();
				switch (poll) {
				case '(':
					str_count[0]++;
					break;
				case ')':
					str_count[1]++;
					break;
				case '[':
					str_count[2]++;
					break;
				case ']':
					str_count[3]++;
					break;
				case '{':
					str_count[4]++;
					break;
				case '}':
					str_count[5]++;
					break;
				case '<':
					str_count[6]++;
					break;
				case '>':
					str_count[7]++;
					break;
				}
			}
			if ((str_count[0] != str_count[1]) || (str_count[2] != str_count[3]) || (str_count[4] != str_count[5])
					|| (str_count[6] != str_count[7])) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
			} else {
				sb.append("#").append(t).append(" ").append(1).append("\n");
			}
		}

		System.out.println(sb);

	}
}
