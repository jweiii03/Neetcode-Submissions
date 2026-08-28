class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String currString = strs.get(i);
            sb.append(currString.length());
            sb.append('#'); // Need this delimeter as length of a smaller string can be 2 digit
            // Use # to identify the END of the length of string
            sb.append(currString);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int ind = 0;
        List<String> decodedStrs = new ArrayList<>();

        while (ind < str.length()) {
            StringBuilder lenOfCurrStr = new StringBuilder();
            while (str.charAt(ind) != '#') {
                lenOfCurrStr.append(str.charAt(ind));
                ind++;
            }

            ind++; // Move past '#'

            int length = Integer.parseInt(lenOfCurrStr.toString());
            System.out.println(length);

            StringBuilder currString = new StringBuilder();
            for (int i = 0; i < length; i++) {
                currString.append(str.charAt(ind));
                ind++;
            }

            decodedStrs.add(currString.toString());
        }

        return decodedStrs;
    }
}
