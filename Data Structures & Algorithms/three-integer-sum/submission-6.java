class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.merge(num, 1, Integer::sum);
        }
        if (numCounts.getOrDefault(0, 0) >= 3) {
            res.add(List.of(0, 0, 0));
        }
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key != 0 && value >= 2 && numCounts.containsKey(-2*key)) {
                res.add(List.of(key, key, -2*key));
            }
        }
        List<Integer> sortedNums = numCounts.keySet().stream().sorted().toList();
        // sortedNums.forEach(x -> System.out.print(x + " "));
        // System.out.println("\n----------");
        for (int curIdx = 1; curIdx < sortedNums.size() -1; curIdx++) {
            int cur = sortedNums.get(curIdx);
            int leftIdx = curIdx - 1;
            int rightIdx = curIdx + 1;
            while (leftIdx >= 0 && rightIdx < sortedNums.size()) {
                int left = sortedNums.get(leftIdx);
                int right = sortedNums.get(rightIdx);
                // System.out.println(left + " " + cur + " " + right);
                if (left + right > -cur) {
                    leftIdx--;
                } else {
                    rightIdx++;
                }
                if (left + cur + right == 0) {
                    res.add(List.of(left, cur, right));
                    // System.out.println("added: " + left + " " + cur + " " + right);
                    leftIdx--;
                    // rightIdx++;
                }
            }
        }
        return res;
    }
}
