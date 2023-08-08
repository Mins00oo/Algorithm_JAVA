package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_1991_트리순회 {
	static int n;
	static ArrayList<ArrayList<Node>> list;
	static StringTokenizer st;
	
	static class Node {
		String leftNode;
		String rightNode;

		public Node(String leftNode, String rightNode) {
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i, new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String now = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			list.get(i).add(new Node(left, right));
		}
	}
	
	static void preorder(String start) {
		
	}

}
