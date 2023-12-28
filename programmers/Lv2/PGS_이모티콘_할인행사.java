package programmers.Lv2;

public class PGS_이모티콘_할인행사 {
    static int[] arr; //
    static int total_cnt;
    static int total_earn;
    static int eSize;

    public int[] solution(int[][] users, int[] emoticons) {
        eSize = emoticons.length;
        int[] answer = new int[2];
        arr = new int[eSize];
        comb(0, users, emoticons);

        answer[0] = total_cnt;
        answer[1] = total_earn;

        return answer;
    }

    private void comb(int idx, int[][] users, int[] emoticons) {
        if (arr.length == idx) {
            // 할인율 배정
            calculate(arr, users, emoticons);
            return;
        }

        for (int i = 10; i <= 40; i += 10) {
            arr[idx] = i;
            comb(idx + 1, users, emoticons);
        }
    }

    private void calculate(int[] arr, int[][] users, int[] emoticons) {
        // users꺼내면서 이모티콘 기준 할인율 이상이면 사고
        // 사고 난 후 총 구매가격이 users[1]보다 크면 가입
        int cnt = 0;
        int earn = 0;

        for (int[] user : users) {
            int discount = user[0];
            int price = user[1];
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= discount) {
                    // 사야함
                    sum += (100 - arr[i]) * (emoticons[i] / 100);
                }
            }
            if (sum >= price) {
                cnt++;
            } else {
                earn += sum;
            }
        }

        if (cnt > total_cnt) {
            total_cnt = cnt;
            total_earn = earn;
            return;
        } else if (cnt == total_cnt) {
            total_earn = Math.max(total_earn, earn);
        }

    }


    public static void main(String[] args) {

    }
}
