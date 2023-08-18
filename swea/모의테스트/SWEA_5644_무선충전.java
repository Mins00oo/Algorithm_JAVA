package swea.모의테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {
	static int T, m, a, ans;
	static int[] pathA, pathB;
	static BC[] bcArray;
	static int ay, ax, by, bx;
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[] dx = { 0, 0, 1, 0, -1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			// path
			pathA = new int[m];
			pathB = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				pathA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				pathB[i] = Integer.parseInt(st.nextToken());
			}

			// BC
			bcArray = new BC[a];

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcArray[i] = new BC(y, x, c, p);
			}

			// 초기화
			ans = 0;

			ay = 1;
			ax = 1;
			by = 10;
			bx = 10;
			// 풀이
			// 매 좌표마다 충전 - 충전할 때 마다 최댓ㄱ밧을 선택해서 ans에 누적합
			for (int i = 0; i < m; i++) {
				ay += dy[pathA[i]];
				ax += dx[pathA[i]];
				by += dy[pathB[i]];
				bx += dx[pathB[i]];
				// 충전
				charge();
			}

			// 출력
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void charge() {
		int max = 0;
		// 현재 ay, ax, by, bx 좌표에서 충전할 수 있는 최대 충전같을 구한 뒤 ans 누적합
		// 완탐
		// 모든 BC에 대해서 위 BC에 대해 모든 BC에 대해서 고려 -> 이중 for문을 사용
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				int sum = 0;
				// a, b 각각 충전 시
				int aPower = getPower(bcArray[i], ay, ax);
				int bPower = getPower(bcArray[j], by, bx);

				if (aPower == 0 && bPower == 0) {
					continue;
				}
				// 두 충전소가 같은지, 다른지에 따라 구별 처리
				if (i != j) { // 두 충전소가 다른 경우
					sum = aPower + bPower;
				} else {
					sum = Math.max(aPower, bPower);
				}
				
				max = Math.max(max, sum);
			}
		}
		ans += max;
	}

	// 충전소와 특정 좌표(y, x)에서 충전할 수 있는 power
	static int getPower(BC bc, int y, int x) {
		if (Math.abs(bc.y - y) + Math.abs(bc.x - x) <= bc.c) {
			return bc.p;
		}
		return 0;
	}

	static class BC {
		int y, x, c, p;

		BC(int y, int x, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}
}







