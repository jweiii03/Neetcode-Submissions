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