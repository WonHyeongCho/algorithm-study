package codility;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        int N = 5;
        int[] A = new int[]{3, 4, 4, 6, 1, 4, 4};
        System.out.print(Arrays.toString(solution(N, A)));
    }

    // 아래 로직을 거꾸로, N+1 일때 모두 맥스로 바꾸지 않고 마지막에 동기화를 해준다
    private static int[] solution(int N, int[] A) {
        int[] answer = new int[N];
        int lastMaxValue = 0;
        int maxValue = 0;

        for(int i = 0; i < A.length; i++) {
            int num = A[i];

            if(num == N+1) {
                lastMaxValue = maxValue;
            }
            else {
                if(answer[num-1] < lastMaxValue) {
                    answer[num-1] = lastMaxValue+1;
                }
                else {
                    answer[num-1]++;
                }

                if(answer[num-1] > maxValue) maxValue = answer[num-1];
            }
        }

        for(int i = 0; i < answer.length; i++) {
            if(answer[i] < lastMaxValue) answer[i] = lastMaxValue;
        }

        return answer;
    }

    // 성능에서 1개를 통과하지 못함, 88점
//    private static int[] solution(int N, int[] A) {
//        int[] answer = new int[N];
//        int preMaxValue = 0;
//        int maxValue = 0;
//
//        for(int i = 0; i < A.length; i++) {
//            int num = A[i];
//
//            if(N >= num) {
//                answer[num-1]++;
//                if(answer[num-1] > maxValue) maxValue = answer[num-1];
//            }
//            else if(num == N + 1 && preMaxValue != maxValue) {
//                for(int j = 0; j < answer.length; j++) {
//                    answer[j] = maxValue;
//                    preMaxValue = maxValue;
//                }
//            }
//        }
//
//        return answer;
//    }
}
