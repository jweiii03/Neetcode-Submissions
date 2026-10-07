class Solution {
    public int candy(int[] ratings) {
        // Edge case: If one child
        if (ratings.length == 1) {
            return 1;
        }

        // Each child start with one candy
        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++) {
            candies[i]++;
        }

        // We search left to right first, comparing curr index with the right neighbour
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }

        // Now we search right to left, comparing curr index with the left neighbour
        for (int i = ratings.length - 1; i > 0; i--) {
            // Check if neighbour larger and if it is, check if its current candy count already 
            // larger than curr index candy
            if (ratings[i] < ratings[i - 1] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }

        int totalCandies = 0;
        for (int c : candies) {
            System.out.println(c);
            totalCandies += c;
        }

        return totalCandies;
    }
}