# Time Complexity: O(n), single pass through list
# Space Complexity: O(n), set stores up to n unique elements

class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        hashset = set()
        for i in nums:
            if i not in hashset:
                hashset.add(i)
            else: 
                return True
        return False
