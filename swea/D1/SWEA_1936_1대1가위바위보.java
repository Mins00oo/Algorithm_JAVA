package swea.D1;

import java.util.Scanner;

public class SWEA_1936_1대1가위바위보 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (b - a >= 1 | b - a == -2) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}

	}
}