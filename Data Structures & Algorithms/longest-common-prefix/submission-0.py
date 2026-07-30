class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 1: 
            return strs[0]
        
        strs = sorted(strs)

        end = 0
        # Loop i times, where i is the smaller string btwn the first and last string
        for i in range(min(len(strs[0]), len(strs[-1]))):
            if strs[0][i] == strs[-1][i]:
                end += 1
            else:
                break
        return strs[0][:end]
                
