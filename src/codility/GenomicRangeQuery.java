package codility;

import java.util.Arrays;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = new int[]{2, 5, 0};
        int[] Q = new int[]{4, 5, 6};
        System.out.print(Arrays.toString(solution(S, P, Q)));
    }

    private static int[] solution(String S, int[] P, int[] Q) {

        return null;
    }

    // 잘못 생각했다...
//    private static int[] solution(String S, int[] P, int[] Q) {
//        int[] answer = new int[P.length];
//        int[][] dp = new int[S.length()][S.length()];
//
//        // dp 초기화
//        for(int i = 0; i < S.length(); i++) {
//            String subSting = S.substring(0, i+1);
//            int impactFactor = 0;
//
//            for(int j = 0; j < subSting.length(); j++) {
//                if(subSting.charAt(j) == 'A') {
//                    impactFactor = 1;
//                    break;
//                }
//                else if(subSting.charAt(j) == 'C') {
//                    if(impactFactor > 2) impactFactor = 2;
//                }
//                else if(subSting.charAt(j) == 'G') {
//                    if(impactFactor > 3) impactFactor = 3;
//                }
//                else if(subSting.charAt(j) == 'T') {
//                    if(impactFactor == 0) impactFactor = 4;
//                }
//            }
//
//            dp[0][i] = impactFactor;
//            System.out.print(dp[0][i] + ", ");
//        }
//
//        for(int i = 0; i < P.length; i++) {
//            int start = P[i];
//            int end = Q[i];
//
//            if(dp[0][end] < dp[0][start]) {
//                answer[i] = dp[0][end];
//            }
//            else {
//                answer[i] = dp[0][start];
//            }
//        }
//
//        return answer;
//    }

    // 25%의 정답률
//    private static int[] solution(String S, int[] P, int[] Q) {
//        int[] answer = new int[P.length];
//
//        for(int i = 0; i < P.length; i++) {
//            int start = P[i];
//            int end = Q[i];
//
//            String query = S.substring(start, end+1);
//
//            for(int j = 0; j < query.length(); j++) {
//                int minimalImpactFactor = Integer.MAX_VALUE;
//                char c = query.charAt(j);
//
//                if(c == 'A') {
//                    answer[i] = 1;
//                    break;
//                }
//                else if(c == 'C') {
//                    minimalImpactFactor = 2;
//                }
//                else if(c == 'G') {
//                    if(minimalImpactFactor > 3) {
//                        minimalImpactFactor = 3;
//                    }
//                }
//                else {
//                    if(minimalImpactFactor > 4) {
//                        minimalImpactFactor = 4;
//                    }
//                }
//
//                answer[i] = minimalImpactFactor;
//            }
//        }
//
//        return answer;
//    }

}
