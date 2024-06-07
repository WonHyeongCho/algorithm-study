package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제공자: 백준
 * 제목: RGB거리
 * URL: https://www.acmicpc.net/problem/1149
 * 난이도: 실버 1
 * 풀이완료시간: 30분
 * 성공여부: 성공
 * 설명: DP 기본문제... 알고리즘 풀이 느낌 끌어올려!!!
 */
public class RGBStreet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[N][3];

        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            costs[i][0] = Integer.parseInt(split[0]); // 빨
            costs[i][1] = Integer.parseInt(split[1]); // 초
            costs[i][2] = Integer.parseInt(split[2]); // 파
        }

        System.out.print(solve(N, costs));
    }

    static int solve(int N, int[][] costs) {
        int[][] dp = new int[N][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }

        int min;

        if(dp[N-1][0] < dp[N-1][1]) {
            min = Math.min(dp[N - 1][0], dp[N - 1][2]);
        } else {
            min = Math.min(dp[N - 1][1], dp[N - 1][2]);
        }

        return min;
    }
}
