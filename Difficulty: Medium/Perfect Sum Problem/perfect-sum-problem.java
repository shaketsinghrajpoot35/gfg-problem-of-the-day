// class Solution {
    
//     static int isSubsetSum(int arr[], int sum) {
        
//         int n = arr.length;//size of arr
       
        
//         int t[][] = new int[n+1][sum+1];
         
//         for(int i=0;i<n+1;i++){
            
//             for(int j=0;j<sum+1;j++){
                
//                 if(i==0){
//                     t[i][j] = 0;
//                 }
                
//                 if(j==0){
//                     t[i][j] = 1;
//                 }
//             }
//         }
        
//         for(int i=1;i<n+1;i++){
            
//             for(int j=1;j<sum+1;j++){
                
//                 if(arr[i-1]<=j){
                    
//                     t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j] ;
                    
                    
//                 } else{
                    
//                     t[i][j] = t[i-1][j];
//                 }
                
//             }
//         }
        
//         return t[n][sum];
        
//     }
//     // Function to calculate the number of subsets with a given sum
//     public int perfectSum(int[] arr, int sum) {
        
//         return isSubsetSum( arr,  sum); 
//     }
// }

class Solution {
    
    static int isSubsetSum(int arr[], int sum) {
        
        int n = arr.length;
        int mod = 1000000007;
        
        int t[][] = new int[n+1][sum+1];
        
        // Initialization
        for(int i = 0; i < n+1; i++){
            t[i][0] = 1;
        }
        
        for(int j = 1; j < sum+1; j++){
            t[0][j] = 0;
        }
        
        // DP Logic
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < sum+1; j++){
                
                if(arr[i-1] <= j){
                    t[i][j] = (t[i-1][j-arr[i-1]] + t[i-1][j]) % mod;
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
    }

    public int perfectSum(int[] arr, int sum) {
        return isSubsetSum(arr, sum); 
    }
}