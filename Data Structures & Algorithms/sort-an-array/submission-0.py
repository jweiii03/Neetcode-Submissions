class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def merge(arr: list[int], l: int, m: int, r: int) -> None:
            left, right = arr[l:m + 1], arr[m + 1: r + 1]
            lenLeft = 0
            lenRight = 0
            ind = l

            while lenLeft < len(left) and lenRight < len(right):
                if left[lenLeft] > right[lenRight]:
                    arr[ind] = right[lenRight]
                    lenRight += 1
                else:
                    arr[ind] = left[lenLeft]
                    lenLeft += 1
                ind += 1
            
            # Add remaining elements from either halved array
            while lenLeft < len(left):
                arr[ind] = left[lenLeft]
                lenLeft += 1
                ind += 1
            
            while lenRight < len(right):
                arr[ind] = right[lenRight]
                lenRight += 1
                ind += 1


        def mergeSort(arr, l, r):
            if l >= r:
                return
            mid: int = (l + r) // 2
            # Divide and Conquer
            mergeSort(arr, l, mid)
            mergeSort(arr, mid + 1, r)
            merge(arr, l, mid, r)
        
        mergeSort(nums, 0, len(nums) - 1)
        return nums