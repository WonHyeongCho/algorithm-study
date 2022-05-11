package codility;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4,};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        int N = A.length+1;
        long sum = ((long)N*(N+1))/2;

        for(int number : A) {
            sum -= number;
        }

        return (int)sum;
    }
}
