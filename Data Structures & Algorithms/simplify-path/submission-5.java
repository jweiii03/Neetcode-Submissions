class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();

        for (int i = 0; i < path.length(); i++) {
            char currChar = path.charAt(i);

            if (currChar == '/') {
                continue;

            // The entire directory name must be exactly ".."
            } else if (
                currChar == '.' &&
                i + 1 < path.length() &&
                path.charAt(i + 1) == '.' &&
                (i + 2 == path.length() || path.charAt(i + 2) == '/')
            ) {
                if (!s.isEmpty()) {
                    s.pop();
                }

                // Move past the second period
                i++;

            // The entire directory name must be exactly "."
            } else if (
                currChar == '.' &&
                (i + 1 == path.length() || path.charAt(i + 1) == '/')
            ) {
                // Ignore "." because it means current directory
                continue;

            } else {
                StringBuilder currDir = new StringBuilder();

                while (i < path.length() && path.charAt(i) != '/') {
                    currDir.append(path.charAt(i));
                    i++;
                }

                s.push(currDir.toString());
            }
        }

        // Edge case: root directory
        if (s.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();

        for (String str : s) {
            ans.append('/');
            ans.append(str);
        }

        return ans.toString();
    }
}