class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        
        int windowXor = 0;
        
        // first window XOR
        for(int i = 0; i < k; i++){
            windowXor ^= arr[i];
        }
        
        int maxXor = windowXor;
        
        // sliding window
        for(int i = k; i < arr.length; i++){
            
            windowXor = windowXor ^ arr[i-k] ^ arr[i];
            
            maxXor = Math.max(maxXor, windowXor);
        }
        
        return maxXor;
    }
}