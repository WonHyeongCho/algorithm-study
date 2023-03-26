package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 제공자: Programers
 * 제목: 신고 결과 받기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java
 * 난이도: Level 1
 * 풀이완료시간: 39분/40분
 * 설명:
 */
public class GetReportResults {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, User> userMap = new HashMap<>();
        int[][] reportMap = new int[id_list.length][id_list.length];

        for(int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], new User(i, id_list[i]));
        }

        for(String str : report) {
            User repoter = userMap.get(str.split(" ")[0]);
            User reported = userMap.get(str.split(" ")[1]);

            if(reportMap[repoter.index][reported.index] != 1) {
                reportMap[repoter.index][reported.index] = 1;

                if(!reported.isStopped) {
                    reported.reportedCount += 1;
                    if(reported.reportedCount >= k) {
                        reported.isStopped = true;
                    }
                }
            }
        }

        userMap.forEach((userName, user) -> {
            if(user.isStopped) {
                for(int i = 0; i < id_list.length; i++) {
                    if(reportMap[i][user.index] == 1) {
                        answer[i] += 1;
                    }
                }
            }
        });

        return answer;
    }

    static class User {
        int index; // 배열 인덱스
        String userName;
        int reportedCount;
        boolean isStopped;

        public User(int index, String userName) {
            this.index = index;
            this.userName = userName;
            reportedCount = 0;
            isStopped = false;
        }
    }
}
