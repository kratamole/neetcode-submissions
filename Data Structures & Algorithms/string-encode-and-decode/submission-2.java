class Solution {
    private static final String DEFAULT_DELIMITER = String.valueOf((char)257);
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return null;
        }
        return String.join(Solution.DEFAULT_DELIMITER, strs);
    }

    public List<String> decode(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        String arr[] = str.split(Solution.DEFAULT_DELIMITER, -1);
        List<String> res = new ArrayList<>();
        for (String s : arr) {
            res.add(s);
        }
        return res;
    }
}
