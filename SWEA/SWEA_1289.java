package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1) 주어지는 문자열을 입력받아서 배열에 저장한 후, 1-> 0 혹은 0->1 이런식으로 바로 옆의 수가 바뀌게 되면 count를 1씩 늘려나감. 이때, 첫 문자열이 1일때는 먼저 +1을 해주고 시작
 * 2) 초기화된 메모리와 비교한다고 생각했을때 비교하는 대상을 만들어준다. 첫 값은 0이 될거고 배열을 순환하면서 다른 값이 나온다면 비교 기준값을 그 값으로 바꿔주고 count+1을 해준다.
 */
public class SWEA_1289 {
	static int t; // 테스트 케이스

//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		t = Integer.parseInt(st.nextToken());
//
//		for (int i = 0; i < t; i++) {
//			String s = br.readLine();
//			System.out.println(s.charAt(1));
//			int[] mem = new int[s.length()];
//			for (int j = 0; j < s.length(); j++) { // 1차원 배열에 입력받는 문자열 추가
//				mem[j] = s.charAt(j) - '0';
//			}
//			int cnt = 0;
//
//			if (mem[0] == 1) {
//				cnt++;
//			}
//
//			for (int k = 0; k < s.length() - 1; k++) {
//				if (mem[k] != mem[k + 1]) {
//					cnt++;
//				}
//			}
//			System.out.println("#" + (i + 1) + " " + cnt);
//		}
//
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			char stand = '0';
			int cnt = 0;
			String s = br.readLine();

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) != stand) {
					stand = s.charAt(j);
					cnt++;
				}
			}
			System.out.println("#" + (i + 1) + " " + cnt);
		}
	}
}
