package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 스위치 개수가 주어지고 상태를 입력받는다.
 * 2. 학생 수를 입력받고, 학생 수에 따라 성별과 받은 수를 저장한다 -> 2차원 배열로? [[1,3], [2,3]] 1이 남자 2가 여자
 * 3. 학생을 전체 돌면서 하나씩 꺼내보는데 성별 먼저 확인하고 남자면 그 스위치 배수에 해당하는 번호를 걍 다 바꿈
 */
public class S4_1244_스위치켜고끄기 {
	static int s_cnt; // 스위치 개수
	static int[] switchs; // 스위치 정보
	static int[][] stdInfo; // 학생정보들
	static int std_cnt; // 학생 수
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s_cnt = Integer.parseInt(br.readLine());
		switchs = new int[s_cnt + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= s_cnt; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		std_cnt = Integer.parseInt(br.readLine());
		stdInfo = new int[std_cnt][2];

		for (int i = 0; i < std_cnt; i++) {
			st = new StringTokenizer(br.readLine());
			stdInfo[i][0] = Integer.parseInt(st.nextToken());
			stdInfo[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < std_cnt; i++) {
			if (stdInfo[i][0] == 1) {
				for (int j = stdInfo[i][1]; j <= s_cnt; j += stdInfo[i][1]) {
					if (switchs[j] == 0) {
						switchs[j] = 1;
					} else {
						switchs[j] = 0;
					}
				}
			} else {
				int n_switch = stdInfo[i][1];
				if (switchs[n_switch] == 0) {
					switchs[n_switch] = 1;
				} else {
					switchs[n_switch] = 0;
				}
				fun(n_switch - 1, n_switch + 1);
			}
		}
		for (int i = 1; i <= s_cnt; i++) {
			System.out.print(switchs[i] + " ");
		}
	}

	static void fun(int n1, int n2) {
		if (n1 < 1 || n2 > s_cnt || switchs[n1] != switchs[n2]) {
			return;
		}
		if (switchs[n1] == switchs[n2]) {
			if (switchs[n1] == 0) {
				switchs[n1] = 1;
				switchs[n2] = 1;
			} else {
				switchs[n1] = 0;
				switchs[n2] = 0;
			}
		}

		fun(n1 - 1, n2 + 1);

	}
}
