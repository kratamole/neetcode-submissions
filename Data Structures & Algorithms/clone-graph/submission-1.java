/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        this.dfs(node, visited);
        return visited.get(node);
    }

    private void dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return;
        }
        Node copy = new Node(node.val);
        visited.put(node, copy);
        for (Node neighbor : node.neighbors) {
            this.dfs(neighbor, visited);
            copy.neighbors.add(visited.get(neighbor));
        }
    }

    private void bfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return;
        }
        Node copy = new Node(node.val);
        visited.put(node, copy);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node iter = queue.poll();
            Node iterCopy = visited.get(iter);
            for (Node neighbor : iter.neighbors) {
                Node neighborCopy = new Node(neighbor.val);
                visited.put(node, neighborCopy);
                queue.add(neighbor);
                iterCopy.neighbors.add(neighborCopy);
            }
        }
    }

}