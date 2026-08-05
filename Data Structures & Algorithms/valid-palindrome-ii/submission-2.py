class Solution:
    def validPalindrome(self, s: str) -> bool:
        left: int = 0
        right: int = len(s) - 1
        deleted: bool = False
        # Two pointer
        while left <= right:
            if s[left] != s[right]:
                # List slicing
                skipL = s[left + 1 : right + 1]
                skipR = s[left : right]
                # Check if reversed list == skipped list
                return skipL == skipL[::-1] or skipR == skipR[::-1]
            left += 1
            right -= 1
        
        return True
        