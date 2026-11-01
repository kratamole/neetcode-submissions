class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int res = -1;
        int offset = 1;
        if (nums[0] < nums[nums.length - 1]) {
            offset = 0;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                offset = i + 1;
                break;
            }
        }
        int left = 0;
        int right = nums.length - 1;
        // int c = 0;
        // while (c++ < 10) {
        while (left <= right) {
            // System.out.println("left: " + left + "; leftOff: " + this.getIdx(left, nums, offset) + "; right: " + right + "; rightOff: " + this.getIdx(right, nums, offset));
            int candidate = left + (right - left) / 2 + (right - left) % 2;
            int candidateOff = this.getIdx(candidate, nums, offset);
            int candidateVal = nums[candidateOff];
            // System.out.println("candidate: " + candidate + "; candidateOff: " + candidateOff + "; candidateVal: " + candidateVal);
            if (candidateVal == target) {
                res = candidateOff;
                break;
            } else if (candidateVal < target) {
                left = candidate + 1;
                // System.out.println("Left changed to: " + left);
            } else {
                right = candidate - 1;
                // System.out.println("Right changed to: " + right);
            }
        }
        return res;
    }

    private int getIdx(int origIdx, int[] arr, int offset) {
        return (origIdx + offset) % arr.length;
    }

    private int restoreIdx(int offsetIdx, int[] arr, int offset) {
        return offset <= offsetIdx ? offsetIdx - offset : arr.length - offset + offsetIdx;
    }
}


// 0 1 2 3 4
// 4 0 1 2 3
// 3 4 0 1 2
// 2 3 4 0 1
// 1 2 3 4 0