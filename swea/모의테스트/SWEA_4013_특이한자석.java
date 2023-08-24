package swea.모의테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {
	static int K, T, ans;
	static int[][] wheel;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int t = 1; t <= T; t++) {
			ans = 0;
			wheel = new int[5][8];
			K = Integer.parseInt(br.readLine());

			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					wheel[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// K번만큼 회전을 시켜주면서
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()); // 몇번 톱니바퀴를
				int w = Integer.parseInt(st.nextToken()); // 어느 방향으로
				checkDir(num, w);
			}

			// 총 K번만큼 회전을 다 시켰다면 점수 합산
			if (wheel[1][0] == 1) {
				ans += 1;
			}
			if (wheel[2][0] == 1) {
				ans += 2;
			}
			if (wheel[3][0] == 1) {
				ans += 4;
			}
			if (wheel[4][0] == 1) {
				ans += 8;
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

	// 어떤 톱니바퀴를 회전시킬지 결정
	static void checkDir(int num, int w) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(num, w);
		// 좌측으로 먼저 검사
		for (int i = num - 1; i >= 1; i--) {
			if (wheel[i + 1][6] != wheel[i][2]) {
				hashMap.put(i, hashMap.get(i + 1) * -1);
			} else {
				break;
			}
		}
		// 우측으로 검사
		for (int i = num + 1; i <= 4; i++) {
			if (wheel[i - 1][2] != wheel[i][6]) {
				hashMap.put(i, hashMap.get(i - 1) * -1);
			} else {
				break;
			}
		}
		turn(hashMap);
	}

	// 톱니바퀴 회전시키기
	static void turn(HashMap<Integer, Integer> hash) {
		for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
			int row = entry.getKey(); // 몇번째 바퀴를
			int val = entry.getValue(); // 어느 방향으로 돌릴지
//			System.out.println("row= " + row);
//			System.out.println("val= " + val);

			if (val == -1) {
				int temp = wheel[row][0]; // 맨 앞의 값을 임시저장
				for (int i = 0; i < 7; i++) {
					wheel[row][i] = wheel[row][i + 1];
				}
				wheel[row][7] = temp;
			} else if (val == 1) {
				int temp = wheel[row][7];
				for (int i = 7; i > 0; i--) {
					wheel[row][i] = wheel[row][i - 1];
				}
				wheel[row][0] = temp;
			}
		}
	}
}
