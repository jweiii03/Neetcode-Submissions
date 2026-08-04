class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        blue_ptr: int = 0
        white_ptr: int = 0
        red_ptr: int = len(nums) - 1

        while red_ptr >= white_ptr:
            curr_num: int = nums[white_ptr]
            if curr_num == 0:
                # Swap blue (0) with white ptr (1)
                temp = nums[white_ptr]
                nums[white_ptr] = nums[blue_ptr]
                nums[blue_ptr] = temp
                blue_ptr += 1
            elif curr_num == 2:
                # Swap white ptr (1) val with red_ptr, and decrement red_ptr
                temp = nums[white_ptr]
                nums[white_ptr] = nums[red_ptr]
                nums[red_ptr] = temp
                red_ptr -= 1
                # Edge case of swapping 2 with 0 need to be handled
                # As 0 needs to be swapped to the front after being swapped to white_ptr
                white_ptr -= 1 # Reevaluate curr index (white_ptr)
            # If curr num == 1, just increment white ptr
            white_ptr += 1
