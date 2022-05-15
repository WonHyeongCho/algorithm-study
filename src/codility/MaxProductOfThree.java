package codility;

import java.util.Arrays;

public class MaxProductOfThree {

    public static void main(String[] args) {
//        int[] A = new int[]{-3, 1, 2, -2, 5, 6};
        int[] A = new int[]{-60, -1, 2, -2, 5, 4};
        System.out.print(solution(A));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);
        int answer = 0;

        if(A[1] < 0 && A[A.length-1] > 0) {
            answer = Math.max(A[0]*A[1]*A[A.length-1], A[A.length-1]*A[A.length-2]*A[A.length-3]);
        }
        else {
            answer = A[A.length-1]*A[A.length-2]*A[A.length-3];
        }

        return answer;
    }
}
