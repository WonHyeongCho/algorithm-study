package codility;

public class PassingCars {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 0, 1, 1};
        System.out.print(solution(A));
    }

    private static int solution(int[] A) {
        int answer = 0;
        int oneCount = 0;

        for(int num : A) {
            oneCount += num;
        }

        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                answer += oneCount;
                if(1000000000 < answer) {
                    answer = -1;
                    break;
                }
            }
            else {
                oneCount--;
            }
        }

        return answer;
    }
}
