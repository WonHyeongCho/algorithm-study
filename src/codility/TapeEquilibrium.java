package codility;

import java.util.Map;

public class TapeEquilibrium {
    public static void main(String[] args) {
//        int[] A = {3, 1, 2, 4, 3};
//        int[] A = {6, 111, 3, 4445, 22, 1023};
        int[] A = {-3 , 1, 3, 7, 9};

        System.out.print(solution(A));
    }

    // DP
    private static int solution(int[] A) {
        int[] dp = new int[A.length];
        int answer = Integer.MAX_VALUE;

        dp[0] = A[0];

        for(int i = 1; i < A.length; i++) {
            dp[i] = dp[i-1] + A[i];
        }

        for(int i = 1; i < A.length; i++) {
            int left = dp[i-1];
            int right = dp[A.length-1] - dp[i-1];
            int diff = Math.abs(left-right);
            answer = Math.min(answer, diff);
        }

        return answer;
    }


    // 정답률 30%
//    private static int solution(int[] A) {
//        int aSum = A[0];
//        int bSum = 0;
//        int diff;
//
//        for(int i = 1; i < A.length; i++) {
//            bSum += A[i];
//        }
//
//        diff = Math.abs(bSum-aSum);
//        int answer = diff;
//
//        for(int i = 1; i < A.length; i++) {
//            diff = Math.abs(diff-2*A[i]);
//
//            if(answer > diff) {
//                answer = diff;
//            }
//        }
//
//        return answer;
//    }
}
