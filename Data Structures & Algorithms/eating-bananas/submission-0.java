class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // h = sum(piles[i]/k, 0, size-1) + sum(min(piles[i]%k, 1), 0, size-1)
        // System.out.println("Target sum: " + h);
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = maxPile < pile ? pile : maxPile;
        }
        int left = 1;
        int right = maxPile;
        int res = -1;

        int tmpC = 0;
        while (left <= right) {
        // while (tmpC++ <= 10) {
            int windowSize = right - left;
            int candidate = left + windowSize / 2;
            long candidateSum = this.sumForK(piles, candidate);
            // System.out.println("Candidate: " + candidate + "; candidate sum: " + candidateSum + "; left: " + left + "; right: " + right);
            if (candidateSum > h) {
                left = candidate + 1;
            } else {
                res = candidate;
                right = candidate - 1;
            }
        }
        return res;
    }

    private long sumForK(int piles[], int k) {
        long res = 0;
        for (long pile : piles) {
            res += pile / k + Math.min(pile % k, 1);
        }
        return res;
    }
}
