package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제공자: 백준
 * 제목: 돌그룹
 * URL: https://www.acmicpc.net/problem/12886
 * 난이도: 골드 4
 * 풀이완료시간: 40/40
 * 성공 여부: 실패
 * 설명: BFS로 접근하는 방식은 맞았음
 * 접근 방식은 비슷했는데 계속 정렬을 한다는 것, String Set으로 한다는것이 시간 초과를 유발
 * A, B, C 이렇게 있을때
 * A, B 를 visited에 저장하고 C를 Total - A + B 로 구하는 개념을 생각했어야함.
 */
public class Problem12886 {
    static boolean[][] visited = new boolean[1501][1501];
    static int total;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        total = A + B + C;

        // 총합이 3으로 나누어지지 않으면 불가능
        if (total % 3 != 0) {
            System.out.println(0);
            return;
        }

        bfs(A, B, C);
    }

    static void bfs(int a, int b, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int z = total - x - y;

            // 모두 같은 경우 찾음
            if (x == y && y == z) {
                System.out.println(1);
                return;
            }

            int[] arr = {x, y, z};

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    if (arr[i] < arr[j]) {
                        int[] next = arr.clone();
                        next[i] += arr[i];
                        next[j] -= arr[i];

                        int nx = next[0], ny = next[1], nz = next[2];
                        int[] sorted = {nx, ny, nz};
                        Arrays.sort(sorted);
                        nx = sorted[0];
                        ny = sorted[1];
                        // z는 total - nx - ny

                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int[] stoneGroup = new int[3];
//        stoneGroup[0] = Integer.parseInt(st.nextToken());
//        stoneGroup[1] = Integer.parseInt(st.nextToken());
//        stoneGroup[2] = Integer.parseInt(st.nextToken());
//
//        if(sum(stoneGroup)%3 != 0) {
//            System.out.println(0);
//            return;
//        }
//
//        Arrays.sort(stoneGroup);
//
//        Set<String> set = new HashSet<>(); // 검사했는지 기억
//        set.add(toString(stoneGroup));
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(stoneGroup);
//
//        while (!queue.isEmpty()) {
//            int[] group = queue.poll();
//
//            for(int i = 0; i < 3; i++) {
//                for(int j = i+1; j < 3; j++) {
//                    int[] newGroup = Arrays.copyOf(group, group.length);
//                    newGroup[j] = newGroup[j] - newGroup[i];
//                    newGroup[i] *= 2;
//
//                    if(isAllEqual(newGroup)) {
//                        System.out.println(1);
//                        return;
//                    } else {
//                        Arrays.sort(newGroup);
//                        String arrString = toString(newGroup);
//                        if(!set.contains(arrString)) {
//                            set.add(arrString);
//                            queue.add(newGroup);
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(0);
//    }
//
//    static int sum(int[] stoneGroup) {
//        int number = 0;
//        for(int i = 0; i < 3; i++) {
//            number += stoneGroup[i];
//        }
//        return number;
//    }
//
//    static String toString(int[] stoneGroup) {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < 3; i++) {
//            sb.append(stoneGroup[i]);
//        }
//        return sb.toString();
//    }
//
//    static boolean isAllEqual(int[] stoneGroup) {
//        int number = stoneGroup[0];
//        for(int i = 1; i < stoneGroup.length; i++) {
//            if (number != stoneGroup[i]) return false;
//        }
//        return true;
//    }
}
