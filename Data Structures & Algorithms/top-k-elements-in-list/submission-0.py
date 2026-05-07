class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hm = {}

        for num in nums:
            hm[num] = 1 + hm.get(num, 0)
        
        # Dictionary/Hashmap does not care about order, hence we bring (key, value) 
        # Pair to array instead
        arr = []
        for key, value in hm.items():
            arr.append([value, key])
        arr.sort()
        
        answer = []
        for i in range(k):
            answer.append(arr[len(arr) - i - 1][1])
            
        return answer