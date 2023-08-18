package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int n, m, d, ans;
	static int[][] map;
	static int[] arrow;
	static List<int[]> enemy = new ArrayList<>(); // 적의 위치를 담을 공간

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		arrow = new int[3];

		// map에 기록하는 동시에 적의 위치를 저장해주고
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					enemy.add(new int[] { i, j });
				}
			}
		}
		
		locate(0, 0);
		System.out.println(ans);

	}

	// 궁수 3명을 배치
	static void locate(int srcIdx, int tgtIdx) {
		if (tgtIdx == 3) {
			// 공격전에 기존 몬스터 배치를 복사해서 카운트를 하도록
			List<int[]> copy = copy(enemy);
			attack(copy);
			return;
		}
		for (int i = srcIdx; i < m; i++) {
			arrow[tgtIdx] = i;
			locate(i + 1, tgtIdx + 1);
		}
	}

	// 적을 제거
	static void attack(List<int[]> copy) {
		int dead = 0;
		
		while (true) {
			for (int i = 0; i < 3; i++) {
				
			}
			
			if (copy.size() == 0) {
				break;
			}
		}

	}

	static List<int[]> copy(List<int[]> list) {
		List<int[]> temp = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			int[] li = list.get(i);
			temp.add(new int[] {li[0], li[1]});
		}
		
		return temp;
	}
}
