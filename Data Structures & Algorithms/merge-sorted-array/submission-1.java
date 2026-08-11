class Solution {
    // Time complexity: O(m+n) — each of the (m+n) elements is processed at most once.
    // Space complexity: O(1) — the merge happens in place using only three pointer variables.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Since there is space at the back, we can compare in descending order (From the back)
        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p3] = nums1[p1];
                p1--;
            } else {
                nums1[p3] = nums2[p2];
                p2--;
            }
            p3--;
        }

        while (p2 >= 0) {
            nums1[p3] = nums2[p2];
            p2--;
            p3--;
        }

        // Dont need while(p1 >= 0), as any remaining num1 elements already in correct position
    }
}