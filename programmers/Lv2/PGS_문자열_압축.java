package programmers.Lv2;

import java.util.HashMap;

public class PGS_문자열_압축 {
    static HashMap<String, Integer> map;
    static int min = Integer.MAX_VALUE;
    
    public int solution(String s) {
        int size = s.length();
        
        int cut = 0;
        for (int i = 1; i < size; i++) { // 1부터 size단위까지
            map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            map.put(s.substring(0, i), 1); // i단위로 먼저 자른 값은 넣고
            String st = s.substring(0, i); // 비교 기준을 잡고
            for (int j = i; j < size; j+=i) {
                if (j + i > size) {
                    // 잘린 문자열이 있을 수 있어서
                    sb.append(s.substring(j, size));
                    break;
                }
                String cur = s.substring(j, j + i);
                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) + 1);
                    cut++;
                } else {
                    if (map.get(st) == 1) { // map에 value가 1일때는 st만append
                        sb.append(st);
                    } else{
                        sb.append(map.get(st)).append(st);
                    }
                    map.remove(st);
                    st = cur;
                    map.put(st, 1);
                    // System.out.println(st);
                }
            }
            if (map.get(st) == 1) { // map에 value가 1일때는 st만append
                sb.append(st);
            } else {
                sb.append(map.get(st)).append(st);
            }
            String alpha = sb.toString();
            min = Math.min(min, alpha.length());
        }
        
        if (cut == 0) {
            return size;
        }
        return min;
    }
}
