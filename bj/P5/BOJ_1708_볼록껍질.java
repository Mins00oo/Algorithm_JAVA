package bj.P5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1708_볼록껍질 {
	static List<Point> list = new ArrayList<>();
	static List<Point> copy_list = new ArrayList<>();
	static Point p;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}
		copy_list = list;
		
		// y가 작은 순으로 정렬을 먼저 해주고
		Collections.sort(copy_list, (x1, x2) -> x1.y - x2.y);
		p = copy_list.get(0); // 기준점이 되는 p
		
		list.sort(new Comparator<Point>() {
			public int compare(Point second, Point third) {
				int ccwResult = ccw(p, second, third);
				if (ccwResult > 0) {
					return -1; // 반시계 방향이기에 오름차순 
				} else if (ccwResult < 0) {
					return 1; // 내림차순
				} else if (ccwResult == 0){ // 직선이라면 거리가 더 증가하도록 배치
					int disR1 = distance(p, second); // 기준점과 p2점 사이의 거리를 구하고 
					int disR2 = distance(p, third); // 기준점과 p2점 사이의 거리를 구하고 
					
					if (disR1 > disR2) {
						return 1;
					}
				}
				return -1;	
			}
		
		});
		
		
	}
	
	static int distance(Point p1, Point p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
		
	}
	
	static int ccw (Point p1, Point p2, Point p3) {
		int result = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x	* p1.y)) - ((p2.x * p1.y) + (p3.x * p2.y) + (p1.x	* p3.y));
		
		if (result > 0) { // 반시계 방향 
			return 1;
		} else if (result < 0) { // 시계 방향 
			return -1;
		} else { // 직선 
			return 0; 
		}
	
	}
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}







