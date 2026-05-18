# Time Complexity: O(n), each number visited at most twice (once to add to set, once during iteration)
# Space Complexity: O(n), set stores all unique numbers

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set()
        for num in nums:
            s.add(num)

        maxVal = 0
        
        for i in range(len(nums)):
            currNum = nums[i]
            if currNum - 1 in s:
                continue
            temp = 1
            while currNum + 1 in s:
                currNum += 1
                temp += 1
            
            maxVal = max(temp, maxVal)
        
        return maxVal
