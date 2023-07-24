package BACKJOON.GOLD;

import java.util.PriorityQueue;
import java.util.Scanner;

public class G4_1715 {
	/*
	 * 카드 묶음을 오름차순으로 정렬을 해서 2개씩 묶음하고 비교 횟수를 더하는게 제일 최소 횟수를 구하는 방법 우선순위 큐를 생성하고 그 안에
	 * 값을 담아준다 큐가 비어질 때 까지 안의 값을 가져오는데 최소 2개가 되어야 비교ㅕ 가능
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int card = sc.nextInt();
			queue.add(card);
		}

		while (queue.size() > 1) {
			int c1 = queue.poll();
			int c2 = queue.poll();

			answer += c1 + c2;
			queue.add(c1 + c2);
		}
		
		System.out.println(answer);

	}

}

