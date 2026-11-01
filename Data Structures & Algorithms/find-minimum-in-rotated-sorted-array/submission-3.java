class Solution {
    public int findMin(int[] nums) {
        switch (nums.length) {
            case 1: return nums[0];
            case 2: return Math.min(nums[0], nums[1]);
            case 3: return Math.min(nums[0], Math.min(nums[1], nums[2]));
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        while (leftIdx + 1 < rightIdx) {
            int windowSize = rightIdx - leftIdx;
            int candidateIdx = leftIdx + windowSize/2 + windowSize%2;
            int candidate = nums[candidateIdx];
            int right = nums[rightIdx];
            int prev = nums[candidateIdx-1];
            int next = nums[candidateIdx+1];
            if (prev < candidate && candidate > next) {
                return next;
            } else if (prev > candidate && candidate < next) {
                return candidate;
            }
            if (candidate > right) {
                leftIdx = candidateIdx;
            } else { // candidate < right
                rightIdx = candidateIdx;
            }
        }
        return -1;
    }
}
// 0123456
// 6012345
// 5601234
// 4560123
// 3456012
// 2345601
// 1234560