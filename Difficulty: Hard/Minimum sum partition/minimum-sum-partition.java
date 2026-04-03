class Solution {
    
    public boolean[][] subSetSum(int arr[],int sum,int n){
        
        // int n = arr.length;
        boolean t[][] = new boolean[n+1][sum+1];
        
        
        //initialization for valid values
        for(int i=0;i<n+1;i++){//n size arr mai 0 sum ka subset exist karta hai 
        
            t[i][0] = true;
            
        }
        
        
        for(int j=1;j<sum+1;j++){//mean 0 size ki arr mai 1 to sum+1 value possible nahi hai
            
            t[0][j] = false;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                
                if(arr[i-1]<=j){
                    
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                } else{
                    
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t;
    }
    public int minDifference(int arr[]) {
        
        int n = arr.length;
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum +=arr[i];
        }
        
        boolean t[][] = subSetSum(arr,sum/2,n);
        
        List<Integer> validS1Values = new ArrayList<>();
        
        int lastRow = t.length-1;
        int columnLen = t[0].length;
        for(int j=0;j<columnLen;j++){
            
            if(t[lastRow][j]){
                validS1Values.add(j);
            }
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int s1 :validS1Values ){
            
            minDiff = Math.min(minDiff, sum - 2*s1);
            
        }
        
        return minDiff;
    }
}
