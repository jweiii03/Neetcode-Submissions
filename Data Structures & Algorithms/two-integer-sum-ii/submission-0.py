# Time Complexity: O(n), two pointer approach, single pass through list
# Space Complexity: O(1), only use constant space for variables

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        answer = []
        left = 0
        right = len(numbers) - 1
        while left < right:
            sum = numbers[left] + numbers[right]
            if sum < target:
                left += 1
            elif sum > target:
                right -= 1
            else:
                break
        answer.append(left + 1)
        answer.append(right + 1)
        return answer
