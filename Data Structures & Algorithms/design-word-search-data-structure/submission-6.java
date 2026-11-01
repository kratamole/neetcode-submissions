class WordDictionary {

    Node root = new Node(' ');

    public WordDictionary() {
    }

    public void addWord(String word) {
        // System.out.println("Insert word: " + word);
        Node iter = this.root;
        for (char c : word.toCharArray()) {
            if (iter.nodes[c-'a'] == null) {
                iter.nodes[c-'a'] = new Node(c);
            }
            iter = iter.nodes[c-'a'];
        }
        iter.isEndOfWord = true;
    }

    public boolean search(String word) {
        return this.recSearch(word, this.root);
    }

    private boolean recSearch(String word, Node start) {
        // System.out.println("Search word: " + word);
        Node iter = start;
        for (int i = 0; i < word.length(); i++) {
            // System.out.println("iter: " + iter);
            char c = word.charAt(i);
            if (c != '.') {
                iter = iter.nodes[c-'a'];
                if (iter == null || (i == (word.length() - 1) && !iter.isEndOfWord)) {
                    return false;
                }
            } else {
                for (Node n : iter.nodes) {
                    if (n != null) {
                        // System.out.println(n);
                        boolean searchRes = this.recSearch(n.val + word.substring(i + 1), iter);
                        if (searchRes) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        // System.out.println("iter: " + iter);
        return iter.isEndOfWord;
    }

    class Node {
        char val;
        Node[] nodes = new Node[26];
        boolean isEndOfWord = false;

        public Node(char val) {
            this.val = val;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("val = " );
            sb.append(this.val);
            sb.append(", isEndOfWord = ");
            sb.append(this.isEndOfWord);
            sb.append(", letters = { ");
            for (Node n : this.nodes) {
                if (n != null) {
                    sb.append(n.val);
                    sb.append(' ');
                }
            }
            sb.append("}");

            return sb.toString();
        }
    }
}
