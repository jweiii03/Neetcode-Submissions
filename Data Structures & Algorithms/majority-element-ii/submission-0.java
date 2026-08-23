class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int threshold = nums.length / 3;
        System.out.println(threshold);
        HashSet<Integer> tracker = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            
            if (!tracker.contains(num) && hm.get(num) > threshold) {
                tracker.add(num);
                ans.add(num);
            }
        }

        return ans;
    }
}