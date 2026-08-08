class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        // Perform binary search 
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // while loop breaks when r == l, r and l will be on the number that is closest to x
        l = l - 1;
        r = l + 1;
        // Window size
        while (r - l - 1 < k) {
            System.out.println(r);
            System.out.println(l);
            if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l + 1; i < r; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}