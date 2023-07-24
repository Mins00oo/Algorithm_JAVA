package BACKJOON.Sliver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S2_5464 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 주차 공간
		int m = sc.nextInt(); // 차량 개수

		int[] parking = new int[n + 1]; // 주차 현황
		int[] parkPrice = new int[n + 1]; // 주차 공간당 무게 요금
		int[] weight = new int[m + 1]; // 차량 무게

		for (int i = 1; i <= n; i++) {
			parkPrice[i] = sc.nextInt();
		}

		for (int i = 1; i <= m; i++) {
			weight[i] = sc.nextInt();
		}

		Queue<Integer> queue = new LinkedList<>();
		int sum = 0;

	       outer: for (int i = 0; i < 2 * m; i++) {
	            int car = sc.nextInt();

	            if (car > 0) { // 들어오는 차라면
	                for (int j = 1; j < n + 1; j++) { // 번호 순대로
	                    if (parking[j] == 0) { // 빈자리가 있으면
	                    	parking[j] = car; // 차를 주차
	                        continue outer;
	                    }
	                }
	                queue.offer(car); //빈자리가 없으면 큐에 넣음
	            } else { // 나가는 차라면
	                for (int j = 1; j < n + 1; j++) {
	                    if (parking[j] == car * (-1)) {
	                    	parking[j] = 0; // 해당 자리를 0으로
	                        sum += parkPrice[j] * weight[car * (-1)];
	                        if (!queue.isEmpty()) parking[j] = queue.poll();
	                        // 큐가 비어있지 않다면 차가 빠져나간 자리에 맨 앞에 있는 차를 넣음
	                        break;
	                    }
	                }
	            }
	        }
		System.out.println(sum);
	}

}
