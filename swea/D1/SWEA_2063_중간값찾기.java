package swea.D1;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2063_중간값찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int middle = N / 2; // 0부터 시작할거라서 +1 안해줘도됨
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		System.out.println(nums[middle]);
	}

}
