package bj.G1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0001 -> 1번 도시 방문
// 1010 -> 2번, 4번 방문
// 1101 -> 1, 3, 4번 도시 방문
// memoi[][] -> 현재 i번 도시에 있고, 거쳐온 도시가 j일 때, 남은 도시를 방문하는데 필요한 최소 비용
// memoi[3][1100101] -> 1, 3, 6, 7 도시를 거쳐서 현재 3번 도시일 때 남은 2 4 5를 방문하는 데 드는 최소 비용
public class BOJ_2098_외판원순회 {
    static int N, allMask, INF = 999_999_999;
    static int[][] W;
    static int[][] memoi;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        
        allMask = ( 1 << N ) - 1; // N 이 이면 1<<5 => 100000 ==> 1을 빼면 11111 (5자리가 모두 1)
        memoi = new int[N][allMask];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 0번째 도시에서 출발
        System.out.println(tsp(0, 1));

    }
    
    static int tsp(int idx, int mask) {
        // 기저조건
        if( mask == allMask ) { // 모든 도시를 방문한 상태 이므로, 처음(0번째 도시) 으로 되돌아가는 비용 처리
            if(W[idx][0] == 0) return INF;
            else return W[idx][0];
        }
        
        // 더 도시를 방문해야 한다.
        if( memoi[idx][mask] != 0 ) return memoi[idx][mask];
        
        // 처음
        memoi[idx][mask] = INF;
        
        // 방문하지 않은 도시를 방문 (재귀)
        for (int i = 0; i < N; i++) {
            // 갈수 없거나, 이미 방문한 경우는 skip
            if(W[idx][i] == 0 || (mask & 1 << i) != 0) continue;
            
            memoi[idx][mask] = Math.min( memoi[idx][mask], tsp(i, mask | ( 1<< i) ) + W[idx][i] );
        }
        
        return memoi[idx][mask];
    }
}





