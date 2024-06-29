from collections import defaultdict
from typing import Iterable, List


class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> Iterable[List[int]]:
        def dfs(u: int) -> set:
            if not ancestors[u]:
                for v in graph[u]:
                    if v not in ancestors[u]:
                        ancestors[u].update({v} | dfs(v))
            return ancestors[u]

        graph = defaultdict(set)
        for u, v in edges:
            graph[v].add(u)

        ancestors = [set() for _ in range(n)]
        for u in range(n):
            if not ancestors[u]:
                dfs(u)

        return map(sorted,ancestors)                                                     