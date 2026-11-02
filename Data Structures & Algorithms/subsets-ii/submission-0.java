class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        this.dfs(numCounts.keySet().stream().toList(), 0, numCounts, new ArrayList<>(), res);
        return res;
    }

    private void dfs(List<Integer> nums, int idx, Map<Integer, Integer> numCounts, List<Integer> path, List<List<Integer>> res) {
        if (idx >= nums.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        res.add(new ArrayList<>(path));
        for (int i = idx; i < nums.size(); i++) {
            int num = nums.get(i);
            int countLeft = numCounts.get(num);
            if (countLeft == 0) {
                continue;
            }
            numCounts.put(num, countLeft - 1);
            path.add(num);
            this.dfs(nums, i, numCounts, path, res);
            numCounts.put(num, countLeft);
            path.remove(path.size() - 1);
        }

    }
}
