package codility;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        int[] A = {};
        int K = 3;

        System.out.print(Arrays.toString(solution(A, K)));
    }

    private static int[] solution(int[] A, int K) {
        int arrayLength = A.length;

        if(arrayLength == 0 || K == 0) return A;

        int sumLength = K%arrayLength;
        int[] answer = new int[arrayLength];

        if(K != arrayLength) {
            for(int i = 0; i < arrayLength; i++) {
                int swiftIndex = i+sumLength;

                if(swiftIndex >= arrayLength) {
                    swiftIndex -= arrayLength;
                }

                answer[swiftIndex] = A[i];
            }
        }
        else {
            answer = A;
        }

        return answer;
    }
}
