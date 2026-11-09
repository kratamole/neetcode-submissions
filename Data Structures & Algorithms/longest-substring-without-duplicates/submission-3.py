class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last_enc_of: dict[int, int] = {}

        left = 0
        right = 0
        res = 0
        while right < len(s):
            last_char_at = last_enc_of.get(s[right])
            last_enc_of[s[right]] = right
            if last_char_at is not None and last_char_at >= left:
                res = max(res, right - left + 1)
                left = last_char_at + 1
            right = right + 1

        return max(res, right - left + 1) - 1




# a b c d c e f g h t