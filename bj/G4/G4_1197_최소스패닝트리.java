package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G4_1197_최소스패닝트리 {
	static int v, e; // 정점의 개수, 간선의 개수
	static ArrayList<Node> list = new ArrayList<>();
	static boolean[] visited;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

	}

	static class Node {

	}
}
