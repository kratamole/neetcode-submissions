class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i+1]) {
                res[i] = 1;
            } else if (temperatures[i] == temperatures[i+1]) {
                res[i] = (res[i+1] == 0) ? 0 : res[i+1] + 1;
            } else {
                for (int j = i + 2; j < n; j++) {
                    if (temperatures[j] > temperatures[i]) {
                        res[i] = j - i;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
