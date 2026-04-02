class Solution {
    
    static boolean subSetSumProblem(int arr[],int n, int sum){
        
        boolean t[][] = new boolean[n+1][sum+1];
        
        for(int i=0;i<n+1;i++){
            t[i][0] = true ;
        }
        
        for(int j=1; j<sum+1;j++){
            t[0][j] = false;
        }
        
        for(int i=1;i<n+1;i++){
            
            for(int j=1; j<sum+1;j++){
                
                if(arr[i-1]<=j){
                               //take                not take
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else{//not take
                    
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
    }
    
    static boolean equalPartition(int arr[]) {
        
        int n = arr.length;
        
        int sum = 0;
        for(int i=0; i<n;i++){
            sum +=arr[i];
        }
        
        if(sum%2 !=0){
            return false;
        } else {
            
            return subSetSumProblem(arr,n,sum/2);
        }
       
    }
}