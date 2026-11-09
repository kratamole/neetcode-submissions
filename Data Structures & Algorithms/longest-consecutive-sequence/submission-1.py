class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0 or len(nums) == 1:
            return len(nums)
        
        dist_nums = set()
        min_val = 1000000000
        max_val = -min_val
        for n in nums:
            dist_nums.add(n)
            if n < min_val:
                min_val = n
            if max_val < n:
                max_val = n
        
        if (min_val >= max_val):
            return 1
        
        longest_int = 0

        for n in dist_nums:
            if (n-1) not in dist_nums:
                candidate = 0
                while (n + candidate) in dist_nums:
                    candidate = candidate + 1
                longest_int = max(longest_int, candidate)

        return longest_int
        