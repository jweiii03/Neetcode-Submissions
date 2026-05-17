class Solution {
    // We cant just add a random special character in between all strings
    // Since this delimeter could show up in some of the words

    // Instead, for each string, place an integer at start of each string
    // that represents the LENGTH of that string!
    // However, we cannot just use a number only since string itself may
    // contain number, hence we require a delimeter AFTER the integer
    // (In this case, we use a #) -> Able to identify start of each string!
    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String currStr = strs.get(i);
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
            while (Character.isDigit(str.charAt(ind))) {
                lenCurrStr.append(str.charAt(ind));
                ind++;
            }
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
