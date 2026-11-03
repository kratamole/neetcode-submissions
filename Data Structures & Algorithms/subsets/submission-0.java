class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        this.dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList(path));
        if (idx == nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            this.dfs(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
