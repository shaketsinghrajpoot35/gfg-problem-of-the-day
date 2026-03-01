class Solution {
    void pushZerosToEnd(int[] arr) {
        
        int i = 0;        // traverse karne ke liye
        int j = 0;        // next non-zero position
        
        while(i < arr.length){
            
            // Agar current element non-zero hai
            if(arr[i] != 0){
                
                // swap arr[i] with arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                j++;   // next position ke liye move karo
            }
            
            i++;  // har case me i increment hoga
        }
    }
}