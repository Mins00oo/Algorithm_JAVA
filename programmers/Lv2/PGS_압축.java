package programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PGS_압축 {
    static List<Integer> list = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    
    public List<Integer> solution(String msg) {
        int idx = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i + "", idx++);
        }
        int size = msg.length();
        for (int i = 0; i < size; i++) {
            int a = 1;
            // i + a가 size보다 더 커질수도 있기에 범위도 같이 체크
            while (i + a <= size && map.containsKey(msg.substring(i, i + a))) a++;
            if(i + a > size) {
                list.add(map.get(msg.substring(i)));
                break;
            }
            list.add(map.get(msg.substring(i, i + a - 1)));
            map.put(msg.substring(i, i + a), idx++);
            if (a > 1) i += a - 2;
        }
        
        return list;
    }
    
    public static void main(String[] args) {
    	System.out.println(new PGS_압축().solution("KAKAO"));
	}
}
