package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제공자: 백준
 * 제목: A와 B
 * URL: https://www.acmicpc.net/problem/12904
 * 난이도: 골드 5
 * 풀이완료시간: 9시24분 PM ~ 9시 48분 PM
 * 성공여부: 성공
 * 설명: 거꾸로 생각하니 쉬웠음. S에서 T를 만드는 것이 아니라 T에서 S를 만든다고 생각함
 */
public class AAndB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.print(solution(S, T));
    }

    static int solution(String S, String T) {
        String modified = T;

        while (modified.length() > S.length()) {
            if(modified.endsWith("A")) {
                modified = modified.substring(0, modified.length()-1);
            } else {
                modified = modified.substring(0, modified.length()-1);
                StringBuilder sb = new StringBuilder(modified);
                modified = sb.reverse().toString();
            }

            if(modified.equals(S)) return 1;
        }

        return 0;
    }

//    static int solution(String S, String T) {
//        Queue<String> queue = new LinkedList<>();
//        queue.add(S);

//        while(!queue.isEmpty()) {
//            String currentString = queue.poll();
//
//            String appendA = appendA(currentString);
//            if(appendA.equals(T)) {
//                return 1;
//            } else {
//                if(appendA.length() < T.length()) {
//                    queue.add(appendA);
//                }
//            }
//
//            String reverseAndAppendB = reverseAndAppendB(currentString);
//            if(reverseAndAppendB.equals(T)) {
//                return 1;
//            } else {
//                if(reverseAndAppendB.length() < T.length()) {
//                    queue.add(reverseAndAppendB);
//                }
//            }
//        }
//
//        return 0;
//    }
//
//    static String appendA(String s) {
//        return s + "A";
//    }
//
//    static String reverseAndAppendB(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        return sb.reverse().append("B").toString();
//    }
}
