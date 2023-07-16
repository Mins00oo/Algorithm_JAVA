package SWEA;

import java.util.Scanner;

public class SWEA_2058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;

		while (n > 1) {
			answer += (n % 10);
			n /= 10;
		}
		System.out.println(answer);
	}
}
