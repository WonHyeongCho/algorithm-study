package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제공자: 백준
 * 제목: 색상환
 * URL: https://www.acmicpc.net/problem/2482
 * 난이도: 골드 3
 * 풀이완료시간: 35/35
 * 성공 여부: 실패
 * 설명: 점화식 자체가 틀렸다. 원형 문제를 선형 문제로 변형 ->
 * 	•	경우 1: 첫 색을 선택하지 않는 경우 → N - 1개의 직선으로 해결 가능
 * 	•	경우 2: 첫 색을 선택한 경우 → 두 번째 색, 마지막 색은 선택 불가 → 길이 N - 3짜리 직선에서 K - 1개 선택
 */
public class Problem2482 {
    static final int MOD = 1_000_000_003;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K > N / 2) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[N + 1][K + 1];

        // 초기값 설정
        for (int i = 0; i <= N; i++) dp[i][0] = 1;
        for (int i = 1; i <= N; i++) dp[i][1] = i;

        // dp[i][j]: i개 중 j개를 인접 없이 고르는 경우의 수 (직선 기준)
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }

        // 원형 고려: 첫 색을 포함하지 않는 경우만 사용
        long answer = (dp[N - 1][K] + dp[N - 3][K - 1]) % MOD;

        System.out.println(answer);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int K = Integer.parseInt(br.readLine());
//        int mod = 1_000_000_003;
//
//        int[][] dp = new int[N + 1][K + 1]; // 열은 K, 로우는 N 즉 N개에서 K개 뽑는 최적
//        dp[1][1] = 1;
//        dp[2][1] = 1;
//        dp[3][1] = 1;
//
//        for(int i = 4; i < N + 1; i++) {
//            for(int j = 1; j < K + 1; j++) {
//                int count = j - 1;
//                int remain = i - 3;
//                int answer = i;
//
//                while(remain >= 0 && count > 0) {
//                    answer *= dp[remain][count];
//                    remain -= 3;
//                    count--;
//                }
//                dp[i][j] = answer / 2;
//            }
//        }
//        System.out.println(dp[N][K] % mod);
//    }
}
