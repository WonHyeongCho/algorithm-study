package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제공자: 백준
 * 제목: 이항 계수
 * URL: https://www.acmicpc.net/problem/11401
 * 난이도: 골드 1
 * 풀이완료시간: /40
 * 성공 여부: -
 * 설명: -
 */
public class BinomialCoefficient {
    static final int MOD = 1_000_000_007;
    static final int MAX_N = 4_000_000;
    static long[] fact = new long[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        solution(N, K);
    }

    static void solution(int N, int K) {
        initFactorial();

        long numerator = fact[N];
        long denominator = (fact[K] * fact[N - K]) % MOD;
        long result = numerator * modInverse(denominator) % MOD;

        System.out.println(result);
    }

    static void initFactorial() {
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
    }

    static long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    static long pow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
