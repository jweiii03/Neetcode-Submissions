class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                ten++;
                if (five == 0) {
                    return false;
                }
                five--;
            } else {
                // b = 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                    continue;
                }
                
                if (five > 2) {
                    five -= 3;
                    continue;
                }

                return false;
            }
        }

        return true;
    }
}