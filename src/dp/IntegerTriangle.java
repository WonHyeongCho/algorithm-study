package dp;

/**
 * 제공자: Programers
 * 제목: 정수 삼각형
 * URL: https://programmers.co.kr/learn/courses/30/lessons/43105
 * 난이도: Level 3
 * 풀이완료시간: 10분
 * 성공여부: 성공
 * 설명: DP 기본문제, 바텀 업 방식
 */
public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        // bottom up 방식으로 제일 아래 설정
        for(int i = 0; i < triangle.length; i++) {
            dp[triangle.length-1][i] = triangle[triangle.length-1][i];
        }

        for(int i = triangle.length-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) { // 대각선
                dp[i][j] = Math.max(triangle[i][j] + dp[i+1][j], triangle[i][j] + dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}
