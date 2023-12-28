package programmers.Lv2;

public class PGS_쿼드압축_후_개수세기 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2]; // 0의 개수와 1의 개수
        // 1, 2, 3, 4분면을 각자 확인 ?
        int len = arr.length;
        check(0, len / 2);
        return answer;
    }

    private void check(int start, int end) {
        System.out.println("start=" + start);
    }

    public static void main(String[] args) {

    }
}
