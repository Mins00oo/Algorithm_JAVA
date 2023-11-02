package programmers.Lv2;

import java.util.ArrayList;
import java.util.List;

public class PGS_2개_이하로_다른비트 {
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            // 짝수면 바로 다음 수
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String s = Long.toString(numbers[i], 2);
                int zeroIdx = s.lastIndexOf("0");
                // 1. 1로만 구성된 홀수
                if (zeroIdx == -1) {
                    s = "10" + s.substring(1, s.length());
                    answer[i] = Long.parseLong(s, 2);
                } else { // 2. 1과 0이 섞여있는 홀수
                    s = s.substring(0, zeroIdx) + "10" + s.substring(zeroIdx + 2, s.length());
                    answer[i] = Long.parseLong(s, 2);
                }
            }
        }
        return answer;
    }
    
    // 시간초과 코드
//    static List<Integer> answer = new ArrayList<>();
//    
//    public List<Integer> solution(long[] numbers) {
//        for (long number : numbers) {
//            String num = Integer.toString((int)number, 2);
//            int num_len = num.length(); // 2의 2진수 길이 
//            int st = (int) number + 1;
//            while (true) {
//                String s = Integer.toString((int)st, 2);
//                int s_len = s.length();
//                int first_diff = s_len - num_len;
//                if (first_diff > 2) continue;
//                
//                s = s.substring(first_diff, s.length());
//                int diff_count = 0;
//                
//                for (int i = 0 ; i < num_len; i++) {
//                    if(num.charAt(i) != s.charAt(i)) diff_count++;
//                }
//                
//                if (first_diff + diff_count <= 2) {
//                    answer.add(st);
//                    break;
//                }
//                st++;
//            } 
//        }
//        return answer;
//    }
}
