package codility;

public class FrogRiverOne {
    public static void main(String[] args) {
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(X, A));
    }

    private static int solution(int X, int[] A) {
        int requiredLeaves = X;
        int answer = -1;

        boolean[] leaves = new boolean[X+1];

        for(int i = 0; i < A.length; i++) {

            if(!leaves[A[i]]) {
                leaves[A[i]] = true;
                requiredLeaves--;
            }

            if(requiredLeaves == 0) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
