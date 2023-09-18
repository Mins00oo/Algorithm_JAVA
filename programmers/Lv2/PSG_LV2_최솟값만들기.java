package programmers.Lv2;

import java.util.Arrays;

public class PSG_LV2_최솟값만들기 {

	public static void main(String[] args) {
		solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
	}

	static int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);
		
		int len = A.length;
		
		for (int i = 0; i < len; i++) {
			answer += A[i] * B[len - i - 1];
		}

		return answer;
	}

}
