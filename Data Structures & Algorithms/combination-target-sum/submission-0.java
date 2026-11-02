class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            if (num <= target) {
                numsList.add(num);
            }
        }
        Collections.sort(numsList);
        List<List<Integer>> res = new LinkedList<>();
        recFunc(numsList, 0, target, new LinkedList<>(), res);
        return res;
    }

    private void recFunc(List<Integer> nums, int start, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num > target) break; // nums is sorted

            path.add(num);
            this.recFunc(nums, i, target - num, path, res); 
            path.remove(path.size() - 1);
        }
    }
}