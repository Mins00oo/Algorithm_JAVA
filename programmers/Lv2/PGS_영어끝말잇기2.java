package programmers.Lv2;

import java.util.HashSet;

public class PGS_영어끝말잇기2 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        char start = words[0].charAt(words[0].length() - 1);
        HashSet<String> log = new HashSet<>();
        
        log.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            log.add(words[i]);
            
            // 앞 단어의 끝으로 시작안하거나 중복된 단어를 한번에 체크 -> HashSet은 중복되면 그냥 덮어씌움
            if (start != words[i].charAt(0) || log.size() != i + 1) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            start = words[i].charAt(words[i].length() - 1);
        }
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(new PGS_영어끝말잇기2().solution(3,
				new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" }));
	}
}






