# Time Complexity: O(n), single pass through list
# Space Complexity: O(n), hashmap stores up to n elements

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        for i in range(len(nums)):
            diff: int = target - nums[i]
            if diff in hm:
                return [hm[diff], i]
            hm[nums[i]] = i
