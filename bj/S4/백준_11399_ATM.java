package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_11399_ATM {
	static int n, sum;
	static int[] p;
	static int[] mem;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = new int[n];
		mem = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		mem[0] = p[0];
		for (int i = 1; i < n; i++) {
			mem[i] = p[i] + mem[i - 1];
		}
		for (int m : mem) {
			sum += m;
		}
		System.out.println(sum);

	}
}
