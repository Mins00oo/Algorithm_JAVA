package programmers.Lv2;

import java.util.ArrayList;
import java.util.List;

public class PGS_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        boolean flag = false;
        
        for (int i = 0; i < words.length; i++) {
            // 앞 사람이 말한걸 말한 경우
            if(list.contains(words[i])) {
                flag = true;
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            list.add(words[i]);
            
            // 이어나가지 못한 경우
            if (i > 0 && words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                flag = true;
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        }
        
        if (flag) return answer;
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(new PGS_영어끝말잇기().solution(3,
				new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" }));
	}
}






