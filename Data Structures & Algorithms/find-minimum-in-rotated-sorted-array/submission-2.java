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
            if (nums[candidateIdx-1] < nums[candidateIdx] && nums[candidateIdx] > nums[candidateIdx+1]) {
                return nums[candidateIdx+1];
            } else if (nums[candidateIdx-1] > nums[candidateIdx] && nums[candidateIdx] < nums[candidateIdx+1]) {
                return nums[candidateIdx];
            }
            if (nums[candidateIdx] > nums[rightIdx]) {
                leftIdx = candidateIdx;
            } else { // candidate < nums[rightIdx]
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