class PrefixTree {
    Node root;

    public PrefixTree() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new Node(c);
            }
            node = node.children[c-'a'];
            if (i == word.length() - 1) {
                node.isEndOfWord = true;
            }
        }
    }

    public boolean search(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                return false;
            }
            node = node.children[c-'a'];
            if (i == word.length() - 1) {
                return node.isEndOfWord;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c-'a'] == null) {
                return false;
            }
            node = node.children[c-'a'];
        }
        return true;
    }

    class Node {
        char val;
        Node[] children = new Node[26];
        boolean isEndOfWord = false;

        Node(char val) {
            this.val = val;
        }
    }
}
