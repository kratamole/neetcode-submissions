class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {0, numbers.length - 1};
        while (numbers[res[0]] + numbers[res[1]] != target) {
            if (numbers[res[0]] + numbers[res[1]] > target) {
                res[1] -= 1;
            } else {
                res[0] += 1;
            }
        }
        res[0] += 1;
        res[1] += 1;
        return res;        
    }
}
