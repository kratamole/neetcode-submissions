class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {0, numbers.length - 1};
        int sum;
        do {
            sum = numbers[res[0]] + numbers[res[1]];
            if (sum > target) {
                res[1] -= 1;
            } else if (sum < target) {
                res[0] += 1;
            }
        } while (sum != target);
        res[0] += 1;
        res[1] += 1;
        return res;        
    }
}
