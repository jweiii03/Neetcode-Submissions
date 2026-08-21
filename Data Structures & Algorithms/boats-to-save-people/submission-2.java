class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Sort and two pointers
        int noOfBoats = 0;
        int right = people.length - 1, left = 0;
        Arrays.sort(people);
        while (left <= right) {
            int currentSum = people[left] + people[right];
            if (currentSum <= limit) {
                left++;
                right--;
            } else {
                // One boat needed for person on right pointer
                right--;
            }

            noOfBoats++;
        }

        return noOfBoats;
    }
}