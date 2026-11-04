class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) {
            return true;
        }
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> nodeNeighbors = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> node0Neighbors = nodeNeighbors.get(edge[0]);
            if (node0Neighbors == null) {
                node0Neighbors = new ArrayList<>();
                nodeNeighbors.put(edge[0], node0Neighbors);
            }
            node0Neighbors.add(edge[1]);
            List<Integer> node1Neighbors = nodeNeighbors.get(edge[1]);
            if (node1Neighbors == null) {
                node1Neighbors = new ArrayList<>();
                nodeNeighbors.put(edge[1], node1Neighbors);
            }
            node1Neighbors.add(edge[0]);
        }
        if (nodeNeighbors.size() != n) {
            return false;
        }

        
        Set<Integer> visitedNodes = new HashSet<>();
        boolean isSubgraphATree = this.dfs(nodeNeighbors, 0, -1, visitedNodes);
        // System.out.println("Visited: " + String.join(" ", visitedNodes.stream().map(String::valueOf).toList()));
        return isSubgraphATree && (visitedNodes.size() == n); // a subgraph IS a tree AND contains all the nodes
        
    }

    private boolean dfs(Map<Integer, List<Integer>> nodeNeighbors, int node, int prevNode, Set<Integer> visited) {
        // System.out.println("+++++++\nNode: " + node);
        // System.out.println("Neighbors: " + String.join(" ", nodeNeighbors.get(node).stream().map(String::valueOf).toList()));
        // System.out.println("Visited: " + String.join(" ", visited.stream().map(String::valueOf).toList()));
        if (!visited.add(node)) { // there is a second path leading to this node
            // System.out.println("A loop leading back to " + node + " found. Return FALSE.");
            return false;
        }
        // System.out.println("Prev node: " + prevNode);
        for (int neighbor : nodeNeighbors.getOrDefault(node, Collections.emptyList())) {
            // System.out.println("Iter neighbor: " + neighbor);
            if (neighbor != prevNode && !this.dfs(nodeNeighbors, neighbor, node, visited)) {
                // System.out.println("A " + node + "'s neighbor (" + neighbor + ") subgraph isn't a valid. Return FALSE.");
                return false;
            }
        }
        // System.out.println("A " + node + "'s subgraph is valid.Return TRUE.");
        return true;
    }

}
