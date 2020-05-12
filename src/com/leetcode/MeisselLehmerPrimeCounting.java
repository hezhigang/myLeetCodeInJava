package com.leetcode;

/**
 * Meissel–Lehmer algorithm
 * In the 1870s, the German astronomer Ernst Meissel discovered a combinatorial method to compute π(x),
 * which was extended and simplified by Derrick H. Lehmer in 1959.
 */
public class MeisselLehmerPrimeCounting {
    private final static int N = 9000;
    private boolean[] np = new boolean[N];
    private int[] prime = new int[N];
    private int[] pi = new int[N];

    private int getprime() {
        int cnt = 0;
        np[0] = np[1] = true;
        pi[0] = pi[1] = 0;
        for (int i = 2; i < N; ++i) {
            if (!np[i])
                prime[++cnt] = i;
            pi[i] = cnt;
            for (int j = 1; j <= cnt && i * prime[j] < N; ++j) {
                np[i * prime[j]] = true;
                if (i % prime[j] == 0)
                    break;
            }
        }
        return cnt;
    }

    private final static int M = 2;
    private final static int PM = 2 * 3 * 5;
    private int[][] phi = new int[PM + 1][M + 1];
    private int[] sz = new int[M + 1];

    public void init() {
        getprime();
        sz[0] = 1;
        for (int i = 0; i <= PM; ++i)
            phi[i][0] = i;
        for (int i = 1; i <= M; ++i) {
            sz[i] = prime[i] * sz[i - 1];
            for (int j = 1; j <= PM; ++j)
                phi[j][i] = phi[j][i - 1] - phi[j / prime[i]][i - 1];
        }
    }

    private int sqrt2(long x) {
        long r = (long) Math.sqrt(x - 0.1);
        while (r * r <= x)
            ++r;
        return new Long(r - 1).intValue();
    }

    private int sqrt3(long x) {
        long r = (long) Math.cbrt(x - 0.1);
        while (r * r * r <= x)
            ++r;
        return new Long(r - 1).intValue();
    }

    private long getphi(long x, int s) {
        if (s == 0)
            return x;
        if (s <= M)
            return phi[new Long(x % sz[s]).intValue()][s] + (x / sz[s]) * phi[sz[s]][s];
        if (x <= prime[s] * prime[s])
            return pi[new Long(x).intValue()] - s + 1;
        if (x <= prime[s] * prime[s] * prime[s] && x < N) {
            int s2x = pi[sqrt2(x)];
            long ans = pi[new Long(x).intValue()] - (s2x + s - 2) * (s2x - s + 1) / 2;
            for (int i = s + 1; i <= s2x; ++i)
                ans += pi[new Long(x / prime[i]).intValue()];
            return ans;
        }
        return getphi(x, s - 1) - getphi(x / prime[s], s - 1);
    }

    private long getpi(long x) {
        if (x < N)
            return pi[new Long(x).intValue()];
        long ans = getphi(x, pi[sqrt3(x)]) + pi[sqrt3(x)] - 1;
        for (int i = pi[sqrt3(x)] + 1, ed = pi[sqrt2(x)]; i <= ed; ++i)
            ans -= getpi(x / prime[i]) - i + 1;
        return ans;
    }

    public long lehmer_pi(long x) {
        if (x < N)
            return pi[new Long(x).intValue()];
        int a = (int) lehmer_pi(sqrt2(sqrt2(x)));
        int b = (int) lehmer_pi(sqrt2(x));
        int c = (int) lehmer_pi(sqrt3(x));
        long sum = getphi(x, a) + (long) (b + a - 2) * (b - a + 1) / 2;
        for (int i = a + 1; i <= b; i++) {
            long w = x / prime[i];
            sum -= lehmer_pi(w);
            if (i > c)
                continue;
            long lim = lehmer_pi(sqrt2(w));
            for (int j = i; j <= lim; j++)
                sum -= lehmer_pi(w / prime[j]) - (j - 1);
        }
        return sum;
    }
}