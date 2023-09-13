package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {
	static int N, sum, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		sum = 0;
		
		for (int a : arr) {
			sum += a;
		}
		
		int start = 1;
		int end = arr[arr.length - 1];
		
		// 예산요청의 합이 M보다 작거나 같으면 최댓값 출력 
		if (sum <= M) {
			System.out.println(arr[arr.length - 1]);
		} else {
			int mid = 0;
			while (start <= end) {
				sum = 0;
				mid = (start + end) / 2;
			
				for (int ar : arr) {
					if (ar >= mid) {
						sum += mid;
					} else {
						sum += ar;
					}
				}
				
				// 국가예산에서 지급 가능한 수준이라면 상한액을 좀 더 올려보고
				if (sum <= M) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			
			System.out.println(end);

		}
	}
}
