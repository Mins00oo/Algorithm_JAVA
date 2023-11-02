package programmers.Lv2;

import java.util.Arrays;

public class PGS_k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String temp = "";
        while (n != 0) {
            temp = n%k + temp; // temp+=로 하면 반대로 됨
            n /= k;
        }
        System.out.println(temp);
        
        String[] arr = temp.split("0");
        
        System.out.println(Arrays.toString(arr));
        
        for(String data : arr) {
            if(data.equals("")) continue;
            Long num = Long.parseLong(data);
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    // 소수인지 판별
    static boolean isPrime(Long num) {
        if (num < 2) return false; // 2부터 소수를 세므로 
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
