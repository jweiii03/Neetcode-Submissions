class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        length = len(nums) / 2
        ans = 0
        d = {}

        for i in range(len(nums)):
            d[nums[i]] = d.get(nums[i], 0) + 1

            if i + 1 > length and d.get(nums[i]) > length:
                ans = nums[i]
        
        return ans