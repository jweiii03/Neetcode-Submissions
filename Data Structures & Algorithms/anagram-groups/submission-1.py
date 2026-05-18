# Time Complexity: O(n * k * log(k)), where n is number of strings and k is length of each string (sorting is O(k * log(k)))
# Space Complexity: O(n * k), hashmap stores all strings

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hm = {}
        for s in strs:
            sortedString = "".join(sorted(s))
            if sortedString in hm:
                hm[sortedString].append(s)
            else: 
                hm[sortedString] = [s]
     
        return list(hm.values())
