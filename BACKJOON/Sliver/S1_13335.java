package BACKJOON.Sliver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_13335 {
	/*
	 * 1. 1자 다리가 있다고 생각하고 그 다리를 만들어준다 -> 앞에 차가 빠지고 뒤에 차가 들어오고 그래야하기 때문에 큐를 생성 2. 맨
	 * 처음 차를 넣고 그 뒤에 차가 다리에 올려고 하는데 이때 트럭 무게를 더해서 최대하중보다 작거나 같은지 확인, 그렇지 않으면 앞에 차를
	 * 빼고 넣는다. 3. 7 들어오고, 빠지고, 4들어오고, 5들어오고, 4빠지고, 5빠지고, 6들어오고, 6빠지고 > 이런 과정을 큐가 빌
	 * 때까지 하면 된다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 트럭의 개수
		int w = sc.nextInt(); // 다리의 길이
		int l = sc.nextInt(); // 다리의 최대하중
		int brideWeight = 0; // 현재 다리의 무게
		int answer = 0;

		Queue<Integer> truck = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			truck.add(sc.nextInt());
		}

		Queue<Integer> bridge = new LinkedList<>();

		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}

		while (!bridge.isEmpty()) { // 다리에 아무것도 없을 때 까지
			System.out.println(bridge.element() + " ");
			brideWeight -= bridge.poll();
			System.out.print(brideWeight + " ");
			if (!truck.isEmpty()) { // 남은 트럭이 없을 때 까지
				if (truck.peek() + brideWeight <= l) { // 다리에 얹을려는 트럭 무게랑 지금 다리 무게를 더했을때 l보다 작거나 같아야 함
					brideWeight += truck.peek();
					bridge.add(truck.poll());
					System.out.println(bridge + " ");
				} else {
					bridge.add(0);
				}
			}
			answer += 1;
		}
		
		System.out.println();
		
		System.out.println(answer);
	}

}
