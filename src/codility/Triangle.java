package codility;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
//        int[] A = new int[]{1, 2, 5, 8, 10, 20};
        int[] A = new int[]{5, 3, 3};
        System.out.print(solution(A));
    }

    private static int solution(int[] A) {
        int answer = 0;

        Arrays.sort(A);

        for(int i = 0; i < A.length-2; i++) {
            if((long)A[i] + (long)A[i+1] > (long)A[i+2]) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}