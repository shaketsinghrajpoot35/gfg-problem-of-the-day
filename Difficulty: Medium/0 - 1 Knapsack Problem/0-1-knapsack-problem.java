
class Solution {
   
    private int t[][] ;
    
    public int knapsackHalper(int W, int val[], int wt[], int n){
        
        
        if(t[n][W] != -1){
            return t[n][W];
        }
        
        
        if(W==0 || n==0){
            
            t[0][0] = 0;
            return 0;//no value add 
        }
        
        
        int result = 0;
        
        if(wt[n-1]<=W){
            
            //eight add ot not two option but find max value from both
            
            int notAddWt = knapsackHalper(W,val,wt,n-1);
            int addWt = val[n-1] + knapsackHalper(W-wt[n-1],val,wt,n-1);
            
            result= Math.max(addWt,notAddWt);
            
           
        }
        
        else if(wt[n-1]>W){
            
            
            result = knapsackHalper(W,val,wt,n-1);
            
        }
        
        t[n][W] = result;
        return  t[n][W];
    }
    
    public int knapsack(int W, int val[], int wt[]) {
        
        int m = val.length+1;
        int n = W+1;
        
        t = new int[m][W+1];
        
        for(int i=0; i<m;i++){
            
            Arrays.fill(t[i],-1);
        }
      
      return knapsackHalper(W,val,wt,val.length);
        
    }
}































// class Solution {
    
//     private HashMap<String,Integer> map;
//     public int knapsackHalper(int W, int val[], int wt[], int n){
        
//         //base case if no capacity remaining w==0 or we have completed all case n==0
        
//         String key = n+"-"+W;
//         if(map.containsKey(key)){
//             return map.get(key);
//         }
        
//         if(W==0 || n==0){
//             map.put(key, 0);
//             return 0;//no value add 
//         }
        
        
//         int result = 0;
        
//         if(wt[n-1]<=W){
            
//             //eight add ot not two option but find max value from both
            
//             int notAddWt = knapsackHalper(W,val,wt,n-1);
//             int addWt = val[n-1] + knapsackHalper(W-wt[n-1],val,wt,n-1);
            
//             result= Math.max( addWt,notAddWt);
            
           
//         }
        
//         else if(wt[n-1]>W){
            
            
//             result = knapsackHalper(W,val,wt,n-1);
            
//         }
        
//         map.put(key,result);
//         return result;
//     }
    
//     public int knapsack(int W, int val[], int wt[]) {
        
//       map = new HashMap<>();
//       return knapsackHalper(W,val,wt,val.length);
        
//     }
// }
