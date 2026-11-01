class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        boolean res = false;
        int[] s1Counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            if (s1Counts[s2.charAt(i)-'a'] > 0) {
                int[] candidateCounts = new int[26];
                boolean skipI = false;
                for (int j = i; j < i + s1.length(); j++) {
                    char c = s2.charAt(j);
                    if (s1Counts[c-'a'] == 0) {
                        skipI = true;
                        break;
                    }
                    candidateCounts[c-'a'] += 1;
                }
                if (skipI) {
                    continue;
                }
                if (Arrays.equals(candidateCounts, s1Counts)) {
                    return true;
                }

            }
        }
        return res;
    }
}
