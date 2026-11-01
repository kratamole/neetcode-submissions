class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return Collections.singletonList(Collections.singletonList(strs[0]));
        }
        Map<Map<Character, Integer>, List<Integer>> signCountIdxsMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> signCountMap = new HashMap<>();
            for (char sign : strs[i].toCharArray()) {
                int count = signCountMap.getOrDefault(sign, 0);
                signCountMap.put(sign, ++count);
            }
            List<Integer> signCountIdxs = signCountIdxsMap.get(signCountMap);
            if (signCountIdxs == null) {
                signCountIdxs = new LinkedList<>();
                signCountIdxsMap.put(signCountMap, signCountIdxs);
            }
            signCountIdxs.add(i);
        }

        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<Map<Character, Integer>, List<Integer>> entry : signCountIdxsMap.entrySet()) {
            List<Integer> idxs = entry.getValue();
            List<String> subarr = new LinkedList<>();
            for (int idx : idxs) {
                subarr.add(strs[idx]);
            }
            res.add(subarr);
        }
        return res;
    }
}
