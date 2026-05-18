# Time Complexity: O(n), single pass to build new string and compare
# Space Complexity: O(n), new string stores filtered characters

class Solution:
    def isPalindrome(self, s: str) -> bool:
        newStr = ''
        for c in s:
            if c.isalnum():
                newStr += c.lower()
        return newStr == newStr[::-1]
