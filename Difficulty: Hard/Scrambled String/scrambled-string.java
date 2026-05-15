// User function Template for Java

class Solution {

    static HashMap<String,Boolean> map;
    static boolean solve(String S1, String S2) {
        
        String key = S1+","+S2;
        
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        // If both strings are equal
        if (S1.equals(S2)) {
            return true;
        }

        // If length becomes 1 and not equal
        if (S1.length() <= 1) {
            return false;
        }

        int n = S1.length();

        boolean flag = false;

        // Try every partition
        for (int i = 1; i < n; i++) {

            // Swap Case
            boolean swapCase =
                    solve(S1.substring(0, i), S2.substring(n - i)) &&
                    solve(S1.substring(i), S2.substring(0, n - i));

            // No Swap Case
            boolean noSwapCase =
                    solve(S1.substring(0, i), S2.substring(0, i)) &&
                    solve(S1.substring(i), S2.substring(i));

            if (swapCase || noSwapCase) {
                flag = true;
                break;
            }
        }


        map.put(key,flag);
        return flag;
    }

    static boolean isScramble(String S1, String S2) {

        // Length check
        if (S1.length() != S2.length()) {
            return false;
        }
        
        map = new HashMap<>();
        
       
        return solve(S1, S2);
    }
}