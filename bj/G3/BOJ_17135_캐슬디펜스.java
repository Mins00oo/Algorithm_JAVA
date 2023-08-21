package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int n, m, d, ans;
	static int[] arrow;
	static List<Monster> enemy = new ArrayList<>(); // 적의 위치를 담을 공간
	static PriorityQueue<Monster> pq = new PriorityQueue<>((e1, e2) -> e1.h == e2.h ? e1.y - e2.y : e1.h - e2.h);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arrow = new int[3];

		// map에 기록하는 동시에 적의 위치를 저장해주고
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int xy = Integer.parseInt(st.nextToken());
				if (xy == 1) {
					enemy.add(new Monster(i, j));
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
			List<Monster> copy = copy(enemy);
			attack(copy);
			return;
		}
		for (int i = srcIdx; i < m; i++) {
			arrow[tgtIdx] = i;
			locate(i + 1, tgtIdx + 1);
		}
	}

	// 적을 제거
	static void attack(List<Monster> list) {
		int dead = 0;

		while (true) {

			for (int i = 0; i < 3; i++) { // 각 궁수마다 잡을 몬스터
				pq.clear();

				for (int j = 0; j < list.size(); j++) { // 몬스터와의 거리를 계산해서 사정거리 안에 있는지
					Monster monster = list.get(j);
					monster.h = Math.abs(monster.x - n) + Math.abs(monster.y - arrow[i]);

					if (monster.h <= d) {
//						System.out.println("d= " + d + "dis= "+ dis);
						pq.offer(monster);
					}
				}

//				for (Monster monster : pq) {
//					System.out.println("monster.x" + monster.x + " monster.y = " + monster.y);
//				}
				// pq안에 있는 몬스터들은 죽었다라고 표시를 해두고
				if (!pq.isEmpty()) {
					pq.poll().isDead = true;
				}
			}

//			System.out.println("====");

			// 죽은 적군을 enemy 제거, 남은 적군 한 칸 아래로 이동, 경계선을 벗어나면 enemy 에서 제거
			for (int i = list.size() - 1; i >= 0; i--) {
				Monster e = list.get(i);
				if (e.isDead) {
//					System.out.println("e.x" + e.x + " e.y = " + e.y);
					list.remove(i);
					dead++;
				} else if (e.x == n - 1) {
					list.remove(i);
				} else {
					e.x++;
				}
			}

//			System.out.println("=====");

			if (list.size() == 0) {
				break;
			}
		}

		ans = Math.max(ans, dead);

	}

	static List<Monster> copy(List<Monster> list) {
		List<Monster> temp = new ArrayList<>();
		// 여기서 새로운 Monster객체를 넣어줘야 하기 때문에 new를 통해 생성해줘야 함!!
		for (int i = 0; i < list.size(); i++) {
			Monster monster = list.get(i);
			temp.add(new Monster(monster.x, monster.y));
		}

		return temp;
	}

	static class Monster {
		int x;
		int y;
		int h;
		boolean isDead;

		public Monster(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
