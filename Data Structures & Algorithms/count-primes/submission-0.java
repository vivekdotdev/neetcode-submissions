class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int ans = 0;
        for(int num = 2; num < n; num++) {
            if(!primes[num]) {
                ans++;
                for (long i = num * 1L * num; i < n; i += num) {
                    primes[(int) i] = true;
                }
            }
        }
        return ans;
    }
}