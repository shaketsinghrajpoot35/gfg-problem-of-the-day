class Solution {
    
    public int unboundedKnapsack(int coins[],int sum){
        
        int n = coins.length;
        int t[][] = new int[n+1][sum+1];
        

        //for 0 sum require 0 coins
        for(int i=0; i<n+1;i++){
            t[i][0] = 0;
        }
        
        
        //in empty arr for sum 1 or to n require infinit coins
        for(int j=1; j<sum+1;j++){
            t[0][j] = Integer.MAX_VALUE-1;
        }
        
        
        //initialize row 1 if j sum divide by sum so initialize with j/sum otherwise infinity-1
        for(int j=1; j<sum+1; j++){
            
            if(j%sum == 0){
                t[1][j] = j/sum;
            } else{
                t[1][j] = Integer.MAX_VALUE - 1;
            }
        }
        
        for(int i=1;i<n+1;i++){
            
            for(int j=1;j<sum+1;j++){
                
                if(coins[i-1]<=j){
                                       //add coin             not add coins
                    t[i][j] = Math.min(1 + t[i][j-coins[i-1]],0+t[i-1][j]);
                } else{
                    
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        if(t[n][sum]==Integer.MAX_VALUE-1){
            return -1;
        }
        return t[n][sum];
        
    }
    public int minCoins(int coins[], int sum) {
        
        return unboundedKnapsack(coins,sum);
        
    }
}