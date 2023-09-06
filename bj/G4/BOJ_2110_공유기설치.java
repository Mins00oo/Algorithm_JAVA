package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] houses = new int[N];

		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		// 이진 탐색을 위한 정렬
		Arrays.sort(houses);

		// 공유기가 같은 좌표에 있지는 않을거니깐 최소 거리차이는 무조건 1
		int left = 1;
		// 초기에 고려해볼 수 있는 거리의 최댓값은 맨 뒤에에서 맨 앞에 거리 뺀 것
		int right = houses[N - 1] - houses[0];
		int maxDistance = 0;

		while (left <= right) {
			// 중앙값 (즉, 공유기 사이의 거리)
			int mid = (left + right) / 2;

			// 첫번째 집을 먼저 기준으로 잡고
			int standHouse = houses[0];
			// mid랑 비교해보면서 공유기가 설치 가능한 집의 개수
			int countHouse = 1;

			for (int i = 1; i < N; i++) {
				if (houses[i] - standHouse >= mid) {
					countHouse++;
					standHouse = houses[i];
				}
			}

			// C개 이상만큼 공유기 설치가 가능해진다면 maxDistance를 갱신해주고
			if (countHouse >= C) {
				maxDistance = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(maxDistance);
	}
}
