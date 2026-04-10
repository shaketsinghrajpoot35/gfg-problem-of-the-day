class Solution {
    
    public static int lcs(String s1, String s2, int m,int  n){
        
        int t[][] = new int[m+1][n+1];
        
        
        //initialization
        for(int i=0;i<m+1;i++){
            
            t[i][0] = 0;
        }
        for(int j=0; j<n+1;j++){
            
            t[0][j] = 0;
        }
        
        for(int i=1;i<m+1;i++){
            
            for(int j=1; j<n+1;j++){
                
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    
                    t[i][j] = 1 + t[i-1][j-1];
                } else{
                    
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[m][n];
        
        
    }
    public static int minSuperSeq(String s1, String s2) {
        
        // m + n - lcs
        //dono stringki length add karo fir dono mai lcs lagao lcs se hame to common lcs milega wo repeat ho raha hai two times so ak lcs ko substract kar denge 
        
        int m = s1.length();
        int n = s2.length();
        
        return m + n - lcs(s1, s2, m, n);
    }
}