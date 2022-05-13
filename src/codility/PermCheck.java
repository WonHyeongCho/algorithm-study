package codility;

import java.util.Arrays;

public class PermCheck {
    public static void main(String[] args) {
        int[] A = new int[]{2};
        System.out.print(solution(A));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);

        int answer = 1;

        for(int i = 0; i < A.length; i++) {
            if(A[i] != i+1) {
                answer = 0;
                break;
            }

        }

        return answer;
    }
}
