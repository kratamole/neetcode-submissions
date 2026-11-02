class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        this.dfs(n, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int openingUsed, int closingUsed, List<Character> path, List<String> res) {
        if (n == openingUsed && n == closingUsed) {
            res.add(this.pathToString(path));
            return;
        } else if (openingUsed < closingUsed) {
            return;
        }
        if (openingUsed < n) {
            path.add('(');
            this.dfs(n, openingUsed + 1, closingUsed, path, res);
            path.remove(path.size() - 1);
        }
        if (closingUsed < n) {
            path.add(')');
            this.dfs(n, openingUsed, closingUsed + 1, path, res);
            path.remove(path.size() - 1);
        }

    }

    private String pathToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }


}
