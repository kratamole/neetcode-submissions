class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0 or len(nums) == 1:
            return len(nums)
        
        dist_nums = set(nums)
        
        longest_int = 0

        for n in dist_nums:
            if (n-1) not in dist_nums:
                candidate = 0
                while (n + candidate) in dist_nums:
                    candidate = candidate + 1
                longest_int = max(longest_int, candidate)

        return longest_int
        