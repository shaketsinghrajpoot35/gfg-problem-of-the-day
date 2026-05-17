import java.util.Arrays;

class Solution {

    static int t[][];

    static int solve(int e, int f) {

        // Base Cases
        if (f == 0 || f == 1)
            return f;

        if (e == 1)
            return f;

        // Memoization
        if (t[e][f] != -1)
            return t[e][f];

        int low = 1;
        int high = f;

        int min = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int breakYes;
            int noBreak;

            // Egg breaks
            if (t[e - 1][mid - 1] != -1) {
                breakYes = t[e - 1][mid - 1];
            } else {
                breakYes = t[e - 1][mid - 1]
                        = solve(e - 1, mid - 1);
            }

            // Egg survives
            if (t[e][f - mid] != -1) {
                noBreak = t[e][f - mid];
            } else {
                noBreak = t[e][f - mid]
                        = solve(e, f - mid);
            }

            int temp = 1 + Math.max(breakYes, noBreak);

            min = Math.min(min, temp);

            // Binary Search
            if (breakYes > noBreak) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return t[e][f] = min;
    }

    static int eggDrop(int n, int k) {

        t = new int[n + 1][k + 1];

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(n, k);
    }
}


// class Solution {

//     static int t[][] ;
    
//     static int solve(int e, int f){
        
//         if(f==0 || f==1){
//             return f;
//         }
        
//         if(e == 1){
//             return f;
//         }
        
        
//         if(t[e][f] != -1){
//             return t[e][f];
//         }
//         int min = Integer.MAX_VALUE;
        
//         for(int k=1;k<=f;k++){
            
            
//             int noBreak = 0;
//             int breakYes = 0;
            
//             if(t[e][f-k] != -1){
//                 noBreak = t[e][f-k] ;
//             } else{
//                 noBreak =t[e][f-k] = solve(e,f-k);
//             }
           
           
//             if(t[e-1][k-1] != -1){
//                 breakYes = t[e-1][k-1];
//             } else{
//                 breakYes =t[e-1][k-1] = solve(e-1,k-1);
//             }
            
            
//             int temp = 1 + Math.max(noBreak,breakYes);
            
//             min = Math.min(min,temp);
//         }
        
//         return t[e][f] = min;
//     }
    
//     static int eggDrop(int n, int k) {
        
//         t = new int[n+1][k+1];
        
//         for(int i=0;i<n+1;i++){
            
//             for(int j=0;j<k+1;j++){
                
//                 t[i][j] = -1;
//             }
//         }
        
//         return solve(n,k);
       
        
//     }
// }



// class Solution {

//     static int t[][] ;
    
//     static int solve(int e, int f){
        
//         if(f==0 || f==1){
//             return f;
//         }
        
//         if(e == 1){
//             return f;
//         }
        
        
//         if(t[e][f] != -1){
//             return t[e][f];
//         }
//         int min = Integer.MAX_VALUE;
        
//         for(int k=1;k<=f;k++){
            
            
//             int noBreak = eggDrop(e,f-k);
//             int breakYes = eggDrop(e-1,k-1);
//             int temp = 1 + Math.max(noBreak,breakYes);
            
//             min = Math.min(min,temp);
//         }
        
//         return t[e][f] = min;
//     }
    
//     static int eggDrop(int n, int k) {
        
//         t = new int[n+1][k+1];
        
//         for(int i=0;i<n+1;i++){
            
//             for(int j=0;j<k+1;k++){
                
//                 t[i][j] = -1;
//             }
//         }
        
//         return solve(n,k);
       
        
//     }
// }






// class Solution {

//     static int eggDrop(int e, int f) {
        
//         if(f==0 || f==1){
//             return f;
//         }
        
//         if(e == 1){
//             return f;
//         }
        
//         int min = Integer.MAX_VALUE;
        
//         for(int k=1;k<=f;k++){
            
            
//             int noBreak = eggDrop(e,f-k);
//             int breakYes = eggDrop(e-1,k-1);
//             int temp = 1 + Math.max(noBreak,breakYes);
            
//             min = Math.min(min,temp);
//         }
        
//         return min;
        
//     }
// }