class Solution {
    
    int lps(String s1, String s2){
        
        int m = s1.length();
        int n = s2.length();
        
        int t[][] = new int[m+1][n+1];
        
        //i==0 || j==0 value will be 0
        
        for(int i=1;i<m+1;i++){
            
            for(int j=1;j<n+1;j++){
                
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    
                    t[i][j] = 1 + t[i-1][j-1];
                } else{
                    
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[m][n];
    }
    
    int findMinInsertions(String s) {
        
        return s.length() - lps(s,new StringBuilder(s).reverse().toString());
        
    }
}