import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        pq = []
        for s in stones:
            heapq.heappush(pq, -s)
        
        while len(pq) > 1:
            stoneOne = -heapq.heappop(pq)
            stoneTwo = -heapq.heappop(pq)
            if stoneOne > stoneTwo:
                heapq.heappush(pq, -(stoneOne - stoneTwo))
        
        if (len(pq)) == 0:
            return 0
        
        return abs(pq[0])
