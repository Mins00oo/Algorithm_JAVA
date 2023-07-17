package BACKJOON;

import java.util.Scanner;

/*
 * 남 여 2명에 1~6학년까지 6개
 * 2차원 배열에 값을 넣어준다 -> 1단계
 * 값을 전부 탐색하면서 k로 나눠주면서 총 방 개수에 더해준다.
 */
public class B2_13300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 16
		int k = sc.nextInt(); // 2
		int room = 0; // 총 방의 개수

		int[][] school = new int[2][7]; // 6학년까지 이므로 +1해서 7
		for (int i = 0; i < n; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			school[gender][grade]++;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if (school[i][j] % k == 0) {
					room += school[i][j] / k;
				} else {
					room += (school[i][j] / k) + 1;
				}
			}
		}

		System.out.println(room);
	}

}
