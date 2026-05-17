class Solution {
    // We cant just add a random special character in between all strings
    // Since this delimeter could show up in some of the words

    // Instead, for each string, place an integer at start of each string
    // that represents the LENGTH of that string!
    // However, we cannot use a number alone as the length prefix, since we
    // would not know where the length integer ends and the actual string begins.
    // Hence we append a '#' after the integer as a delimiter to mark the boundary.
    // e.g. "12#" → length is 12, string starts after '#'

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String currStr = strs.get(i);
            // Add len of string followed by # for EACH String
            s.append(currStr.length());
            s.append("#");
            s.append(currStr);
        }

        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> lis = new ArrayList<>();
        int ind = 0;

        while (ind < str.length()) {
            StringBuilder lenCurrStr = new StringBuilder();
            // Iterate until no longer a digit
            while (Character.isDigit(str.charAt(ind))) {
                lenCurrStr.append(str.charAt(ind));
                ind++;
            }
            // Check if currChar is #, if it is, means its the start of the string
            if (str.charAt(ind) == '#') {
                ind++;
                int currLen = Integer.parseInt(lenCurrStr.toString());
                StringBuilder currStr = new StringBuilder();
                while (currLen > 0) {
                    currStr.append(str.charAt(ind));
                    ind++;
                    currLen--;
                }
                lis.add(currStr.toString());
            } 
        }
        return lis;
    }
}
