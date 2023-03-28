package codility;

import java.util.ArrayList;
import java.util.List;

public class YanoljaTest2 {
    public static void main(String[] args) {
//        String S = "babaa";
//        String S = "bbbab";
//        String S = "bbbaaabbb";
        String S = "abbabbaaa";
        System.out.print(solution(S));
    }

    private static int solution(String S) {
        List<Integer> blockSizeList = new ArrayList<>();

        char preChar = S.charAt(0);
        int size = 0;
        int maximumSize = 0;

        for(int i = 1; i < S.length(); i++) {
            size++;

            char currentChar = S.charAt(i);

            System.out.println(currentChar + ", " + size);

            if(preChar != currentChar) {
                blockSizeList.add(size);
                preChar = currentChar;
                maximumSize = Math.max(maximumSize, size);
                size = 0;
            }
        }


        // 마지막 블록에 대한 처리
        size++;
        blockSizeList.add(size);
        maximumSize = Math.max(maximumSize, size);

        int answer = 0;

        for (Integer blockSize : blockSizeList) {
            System.out.println(blockSize);
            answer += (maximumSize - blockSize);
        }

        return answer;
    }
}
