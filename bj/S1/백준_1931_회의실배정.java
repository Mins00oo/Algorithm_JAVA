package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_1931_회의실배정 {
	static int n;
	static int cnt = 1;
	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, (o1, o2) -> {
			if (o1.e == o2.e) {
				return o1.s - o2.s;
			}
			return o1.e - o2.e;
		});
		solve();
		System.out.println(cnt);
	}

	static void solve() {
		int end = list.get(0).e;
		for (int i = 1; i < n; i++) {
			if (list.get(i).s < end) {
				continue;
			} else {
				cnt++;
				end = list.get(i).e;
			}
		}
	}

	static class Node {
		int s, e;

		Node(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

}
