package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_12891_DNA비밀번호 {
	static int s, p;
	static char[] src;
	static int cnt; // 구해야 하는 전체 횟수
	static int[] check; // A C G T 순으로
	static int[] myArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()); // 문자열 길이
		p = Integer.parseInt(st.nextToken()); // 부분문자열 길이

		st = new StringTokenizer(br.readLine(), "");
		String s1 = st.nextToken();
		src = new char[p];
		for (int i = 0; i < p; i++) {
			src[i] = s1.charAt(i);
		}

		check = new int[4];
		myArr = new int[4];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}

		// 처음 p만큼 부분문자열 생성
		for (int i = 0; i < p; i++) {
			if (s1.charAt(i) == 'A') {
				myArr[0]++;
			} else if (s1.charAt(i) == 'C') {
				myArr[1]++;
			} else if (s1.charAt(i) == 'G') {
				myArr[2]++;
			} else if (s1.charAt(i) == 'T') {
				myArr[3]++;
			}
		}

		if (isSuccess()) {
			cnt++;
		}

		for (int i = p; i < s; i++) {
			if (s1.charAt(i - p) == 'A') {
				myArr[0]--;
			} else if (s1.charAt(i - p) == 'C') {
				myArr[1]--;
			} else if (s1.charAt(i - p) == 'G') {
				myArr[2]--;
			} else if (s1.charAt(i - p) == 'T') {
				myArr[3]--;
			}

			if (s1.charAt(i) == 'A') {
				myArr[0]++;
			} else if (s1.charAt(i) == 'C') {
				myArr[1]++;
			} else if (s1.charAt(i) == 'G') {
				myArr[2]++;
			} else if (s1.charAt(i) == 'T') {
				myArr[3]++;
			}
			if (isSuccess()) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	static boolean isSuccess() {
		for (int i = 0; i < 4; i++) {
			if (myArr[i] < check[i]) {
				return false;
			}
		}
		return true;
	}
}
