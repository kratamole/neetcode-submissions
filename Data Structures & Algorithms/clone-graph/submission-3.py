"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        clone: dict = {}

        def dfs(node: Optional['Node']) -> Optional['Node']:
            if not node:
                return None
            if node in clone:
                return clone[node]

            copy = Node(node.val)
            clone[node] = copy

            for n in node.neighbors:
                copy.neighbors.append(dfs(n))
            return copy

        return dfs(node)

        