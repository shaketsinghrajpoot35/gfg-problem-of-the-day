// class Solution {
    
//     static final int  currency[] = {10,5,2,1};
   
//   public int solve(int n, int min, int idx){
       
//       if(n == 0 || idx ==4){
//           return min;
//       }
       
//       min += n/currency[idx];
       
//       return solve(n%currency[idx], min, idx++);
//   }
    
//     public int findMin(int n) {
        
//         return solve(n,0,0);

//     }
// }


class Solution {
    
   static final int  currency[] = {10,5,2,1};

    public int findMin(int n) {
        
        int min = 0;
        for(int i=0;i<currency.length;i++){
            
            min += n/currency[i];
            n %= currency[i];
            
            if(n == 0){
                break;
            }
        }
        
        return min;

    }
}

