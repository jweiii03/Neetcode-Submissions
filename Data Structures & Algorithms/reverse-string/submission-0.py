import math

class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        end: int = len(s) - 1
        half_len: int = math.floor(len(s) / 2)
        for front in range(half_len):
            temp = s[front]
            s[front] = s[end]
            s[end] = temp
            end -= 1
        return s


        