package codility;

public class YanoljaTest1 {
    public static void main(String[] args) {
        String S = "Sun";
        int K = 13;
        System.out.println(solution(S, K));
    }

    private static String solution(String S, int K) {
        String[] dayArray = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int startIndex = 0;

        for(int i = 0; i < dayArray.length; i++) {
            if(dayArray[i].equals(S)) {
                startIndex = i;
                break;
            }
        }

        return dayArray[(K%7+startIndex)%7];
    }
}
