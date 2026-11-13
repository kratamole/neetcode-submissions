class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 1) {
            return Collections.singletonList(Collections.singletonList(s));
        }
        List<List<Integer>> palindromesStartingAt = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            // System.out.print("s[" + i + "] = " + s.charAt(i) + ": ");
            palindromesStartingAt.add(new LinkedList<Integer>());
            for (int j = i; j < len; j++) {
                if (this.isSubstrPalindrome(s, i, j)) {
                    palindromesStartingAt.get(i).add(j);
                    // System.out.print(s.substring(i, j + 1) + " ");
                    // j += j - i; // if s[i..j] is palindrome, then the next possible palindrome is possible at s[i..j+(j-i)]
                }
            }
            // System.out.println();
        }
        List<List<String>> res = new ArrayList<>();
        this.dfs(s, 0, palindromesStartingAt, new ArrayList(), res);
        return res;
    }

    private void dfs(String s, int start, List<List<Integer>> palindromesStartingAt, List<String> path, List<List<String>> resAccum) {
        if (start == s.length()) {
            resAccum.add(new ArrayList(path));
            return;
        }
        for (int palindromeEnd : palindromesStartingAt.get(start)) {
            path.add(s.substring(start, palindromeEnd + 1));
            this.dfs(s, palindromeEnd + 1, palindromesStartingAt, path, resAccum);
            path.remove(path.size() - 1);
        }
    }

    private boolean isSubstrPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        for (int i = start; i <= (start + end) / 2; i++) {
            if (s.charAt(i) != s.charAt(start + end - i)) {
                return false;
            }
        }
        return true;
    }
}
