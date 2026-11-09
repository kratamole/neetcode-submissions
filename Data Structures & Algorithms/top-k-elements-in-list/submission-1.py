class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = {}
        for n in nums:
            freqs[n] = freqs.get(n, 0) + 1

        arr = []
        for n, freq in freqs.items():
            if len(arr) < k:
                heapq.heappush(arr, (freq, n))
            else:
                heapq.heappushpop(arr, (freq, n))
        return list(map(lambda p : p[1], arr))