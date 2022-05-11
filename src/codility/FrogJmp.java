package codility;

public class FrogJmp {
    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;
        System.out.println(solution(X, Y, D));

    }

    private static int solution(int X, int Y, int D) {
        int answer = (Y-X)/D;

        if((Y-X)%D != 0) answer++;

        return answer;
    }
}
