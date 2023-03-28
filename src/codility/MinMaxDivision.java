package codility;

public class MinMaxDivision {
    public static void main(String[] args) {

    }

    private static int solution(int K, int M, int[] A) {
        int sum = 0;
        int max = 0;

        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(A[i] > max) max = A[i];
        }

        int result = sum;

        while(max <= sum) {

        }

        return 0;
    }

    private static boolean isDivisable(int mid, int K, int[] A) {
        int size = K;
        int sum = 0;

        for(int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if(sum > mid) {
                size --;
                sum = A[i];
            }
            if(size == 0) {
                return false;
            }
        }

        return true;
    }
}


