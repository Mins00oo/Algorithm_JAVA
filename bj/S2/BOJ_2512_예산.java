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
		
		int start = arr[0];
		int end = arr[arr.length - 1];
		
		// 예산요청의 합이 M보다 작거나 같으면 최댓값 출력 
		if (sum <= M) {
			System.out.println(arr[arr.length - 1]);
		} else {
			sum = 0;
			int mid = (start + end) / 2;
			
			for (int ar : arr) {
				if (ar >= mid) {
					sum += mid;
				} else {
					sum += ar;
				}
			}
			
			if (sum <= M) {
				
			}
		}
	}
}
