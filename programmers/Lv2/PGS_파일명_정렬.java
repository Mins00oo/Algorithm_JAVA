package programmers.Lv2;

import java.util.Arrays;

public class PGS_파일명_정렬 {
    
    public String[] solution(String[] files) {
        
        // System.out.println(num);
        Arrays.sort(files, (o1, o2) -> {
            String[] file1 = detach(o1);
            String[] file2 = detach(o2);
            
            // head 문자열끼리 비교
            int headValue = file1[0].compareTo(file2[0]);
            
            if (headValue == 0) { // 동일한 head라면 number로 비교
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);
                
                return num1 - num2;
            } else {
                return headValue; 
            }
        });
        
        return files;
    }
    
    // head, number, tail을 String배열로 리턴해주는 곳
    // 리턴해주고 main에서는 반환받은 배열갖고 정렬해주도록 Arrays.sort로
    static String[] detach(String str) {
        String head = "";
        String number = "";
        String tail = "";
        
        int len = str.length();
        int start = 0;
        
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                start = i;
                break;
            } // 숫자라면 중단
            head += c;
        }
        
        for (int i = start; i < len; i++) {
            char c = str.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                start = i;
                break;
            } // 숫자라면 중단
            number += c;
        }
        
        for (int i = start; i < len; i++) {
            char c = str.charAt(i);
            tail += c;
        }
        
        return new String[] {head.toLowerCase(), number, tail};
        
    }
}
