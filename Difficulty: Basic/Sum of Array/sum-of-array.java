// User function Template for Java

class Solution {
    
    int recursion(int arr[], int i){
        
        if(i == arr.length-1) return arr[i];
        
        return arr[i] +  recursion(arr,  i+1);
    }
    int arraySum(int arr[]) {
        
        return  recursion(arr, 0);
        
    }
}
