class Solution {
    char[][] digToChars = new char[][]{
        {' '},           // 0
        {},              // 1
        {'a', 'b', 'c'}, // 2
        {'d', 'e', 'f'}, // 3
        {'g', 'h', 'i'}, // 4
        {'j', 'k', 'l'}, // 5
        {'m', 'n', 'o'}, // 6
        {'p', 'q', 'r', 's'}, // 7
        {'t', 'u', 'v'}, // 8
        {'w', 'x', 'y', 'z'} // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        this.recFunc(digits, 0, new ArrayList<>(), res);
        return res;
    }

    private void recFunc(String digits, int start, List<Character> path, List<String> res) {
        if (start >= digits.length()) {
            if (path.size() > 0) {
                res.add(charsToString(path));
            }
            return;
        }
        int curDig = digits.charAt(start) - '0';
        for (char c : this.digToChars[curDig]) {
            path.add(c);
            this.recFunc(digits, start + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    private String charsToString(List<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
