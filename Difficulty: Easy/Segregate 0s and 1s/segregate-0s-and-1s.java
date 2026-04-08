class Solution {
    void segregate0and1(int[] arr) {
        
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right) {
            
            // Move left pointer if 0
            if(arr[left] == 0) {
                left++;
            }
            
            // Move right pointer if 1
            else if(arr[right] == 1) {
                right--;
            }
            
            // Swap
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                
                left++;
                right--;
            }
        }
    }
}

