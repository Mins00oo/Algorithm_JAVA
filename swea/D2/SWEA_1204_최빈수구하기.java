package swea.D2;

import java.util.Scanner;

public class SWEA_1204_최빈수구하기 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt(); // 테스트 케이스 번호
			int[] arr = new int[101]; // 빈도 저장할 배열

			// 입력받은 숫자 빈도수 체크
			for (int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++;
			}

			int max = 0;
			int index = 0;
			// 최빈값 비교
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= max) {
					max = arr[i];
					index = i;
				}
			}

			System.out.println("#" + n + " " + index);
		}
	}

}
