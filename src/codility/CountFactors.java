package codility;

public class CountFactors {

    public static void main(String[] args) {
        int N = 36;
        System.out.print(solution(N));
    }

    private static int solution(int N) {
        int answer = 0;

        if(N == 1) return 1;

        for(int i = 1; i <= Math.sqrt(N); i++) {
            if(N%i == 0) {
                if(N/i == i) {
                    answer++;
                }
                else {
                    answer += 2;
                }
            }
        }

        return answer;
    }
}
