class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s, int index, ArrayList<String> path, List<String> result) {
        // If we already have 4 parts but not at end → invalid
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;
            String part = s.substring(index, index + len);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') continue;

            // Range check
            int val = Integer.parseInt(part);
            if (val > 255) continue;

            path.add(part);
            backtrack(s, index + len, path, result);
            path.remove(path.size() - 1);
        }
    }
}