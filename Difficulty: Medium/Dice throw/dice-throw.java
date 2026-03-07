class Solution {
    
    static int fun(int n, int m, int x,int [][]dp){
          
          if(x==0 && n==0)return 1;
          if(x<0 || n<0)return 0;
          
          if(dp[n][x]!=-1)return dp[n][x];
          
          int count=0;
          for(int i=1;i<=m;i++){
               count+=fun(n-1,m,x-i,dp);
          }
          
          return dp[n][x]=count;
    }
    static int noOfWays(int m, int n, int x) {
          int [][]dp=new int[n+1][x+1];
          for(int i=0;i<dp.length;i++){
              for(int j=0;j<dp[0].length;j++){
                  dp[i][j]=-1;
              }
          }
          return fun(n,m,x,dp);
    }
};