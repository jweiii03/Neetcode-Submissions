class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> wellFormedParenthesis = new ArrayList<>();
        wellFormedParenthesis.add("()");

        for (int i = 1; i < n; i++) {
            List<String> temp = new ArrayList<>();
            HashSet<String> hs = new HashSet<>();
            for (String curr : wellFormedParenthesis) {
                for (int j = 0; j < curr.length(); j++) {
                    if (curr.charAt(j) == '(') {
                        StringBuilder sb = new StringBuilder();
                        sb.append(curr.substring(0, j + 1));
                        sb.append("()");
                        sb.append(curr.substring(j + 1));
                        String newParenthesis = sb.toString();

                        if (!hs.contains(newParenthesis)) {
                            temp.add(newParenthesis);
                            hs.add(newParenthesis);
                        }

                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(curr.substring(0, j));
                        sb2.append("()");
                        sb2.append(curr.substring(j));
                        String newParenthesisTwo = sb2.toString();

                        if (!hs.contains(newParenthesisTwo)) {
                            temp.add(newParenthesisTwo);
                            hs.add(newParenthesisTwo);
                        }
                    }
                }
            }
            wellFormedParenthesis = temp;
        }

        return wellFormedParenthesis;
    }
}
