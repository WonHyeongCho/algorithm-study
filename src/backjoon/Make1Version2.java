package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제공자: 백준
 * 제목: 1로 만들기 2
 * URL: https://www.acmicpc.net/problem/12852
 * 난이도: 실버 1
 * 풀이완료시간: -
 * 성공 여부: -
 * 설명: -
 */
public class Make1Version2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(br.readLine());
    solution(number);
  }

  static void solution(int N) {
    int[] dp = new int[N + 1];
    int[] prev = new int[N + 1];

    dp[1] = 0;

    for(int i = 2; i <= N; i++) {
      dp[i] = dp[i - 1] + 1;
      prev[i] = i - 1;

      if(i % 2 == 0 && dp[i/2] < dp[i]) {
        dp[i] = dp[i/2] + 1;
        prev[i] = i / 2;
      }
      if(i % 3 == 0 && dp[i/3] < dp[i]) {
        dp[i] = dp[i/3] + 1;
        prev[i] = i / 3;
      }
    }

    System.out.println(dp[N]);

    // 경로 복원
    StringBuilder path = new StringBuilder();
    int curr = N;
    while (curr > 0) {
      path.append(curr).append(" ");
      curr = prev[curr];
    }

    System.out.println(path.toString().trim());
  }
}
