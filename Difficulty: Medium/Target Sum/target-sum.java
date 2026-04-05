class Solution {
    
    public int subSetSum(int arr[], int sum, int n){
        
        int t[][] = new int[n+1][sum+1];
        
        // initialization
        for(int i=0;i<n+1;i++){
            t[i][0] = 1; // sum 0 can be formed by empty subset
        }
        
        for(int j=1;j<sum+1;j++){
            t[0][j] = 0; // no elements → no subset
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                } else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
    }
    
    public int totalWays(int[] arr, int target) {
        
        int n = arr.length;
        int totalSum = 0;
        
        for(int num : arr){
            totalSum += num;
        }
        
        
        if((totalSum + target) % 2 != 0) return 0;
        
        int s1 = (totalSum + target) / 2;
        
        return subSetSum(arr, s1, n);
    }
}