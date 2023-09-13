package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20006_랭킹전대기열 {
	static int p, l, m; // 플레이어의 수, 닉네임, 레벨, 방의 정원
	static List<Room> rooms = new ArrayList<>();
	static String n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken()); // 플레이어 수
		m = Integer.parseInt(st.nextToken()); // 정원 
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			n = st.nextToken();
			boolean added = false;
			
			for (Room room : rooms) {
				
				if (room.users.size() == m) {
					continue;
				}
				// 그냥 방에 아무도 없을 경우에는 먼저 들어가있고 
				if (!room.users.isEmpty() && room.users.get(0).level + 10 >= l && room.users.get(0).level - 10 <= l) {
					room.users.add(new Node(l, n));
					added = true;
					break;
				}
			}
			if (!added) {
				Room newRoom = new Room();
				newRoom.users.add(new Node(l, n));
				rooms.add(newRoom);
			}
		}
		
		for (Room room : rooms) {
			Collections.sort(room.users);
			
			if (room.users.size() == m) {
				sb.append("Started!").append("\n");
			} else {
				sb.append("Waiting!").append("\n");
			}
			
			// 방에 ㅇ누가 있는지 users 출력
			for (int i = 0; i < room.users.size(); i++) {
				sb.append(room.users.get(i).level).append(" ").append(room.users.get(i).name).append("\n");
			}
		}
		
		System.out.println(sb);
		
		
	}
	
	static class Node implements Comparable<Node>{
		int level;
		String name;
		
		public Node(int level, String name) {
			this.level = level;
			this.name = name;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.name.compareTo(o.name);
		}
		
	}
	
	static class Room {
		List<Node> users = new ArrayList<>();
	}
}
