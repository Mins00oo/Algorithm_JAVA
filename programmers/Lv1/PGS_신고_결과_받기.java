package programmers.Lv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PGS_신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 같은 key에 대한 같은 value값 중복을 방지하기 위해
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
        }

        for (String r : report) {
            String[] str = r.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }

        System.out.println("map = " + map);

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> value = map.get(id_list[i]);
            // k번 이상 신고를 받았다면
            if (value.size() >= k) {
                // 신고한 유저가 받을 결과 메일 수 ++
                for (String s : value) {
                    answer[idxMap.get(s)]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        new PGS_신고_결과_받기().solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 3);
    }
}
