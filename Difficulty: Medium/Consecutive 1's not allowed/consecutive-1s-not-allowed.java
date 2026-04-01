


class Solution {
    int countStrings(int n) {
        // code here
        int first = 2;
        if(n == 1) return first;
        
        int second = 3;
        if(n == 2) return second;
        
        int next = 0;
        for(int i = 0; i < n - 2; i++){
            next = first + second;
            first = second;
            second = next;
        }
        
        return next;
    }
}




































// class Solution {
    
//     int count[] ;
//     void  countStringHelper(int n, String s){
        
       
//         if(s.length() == n){
//             // System.out.println(s);
//             count[0] ++;
//             return ;
            
//         }
        
//         if(s.length()==0){
//             countStringHelper( n, s+"1");
//             countStringHelper( n, s+"0");
//             return ;
//         }
        
//         char  lastCh = s.charAt(s.length()-1);
        
//         if(lastCh == '1'){
             
//              countStringHelper( n, s+"0");
//         } else{
            
            
//             countStringHelper( n, s+"1");
//             countStringHelper( n, s+"0");
            
//         }
//     }
//     int countStrings(int n) {
//         count = new int[1];
        
//          countStringHelper( n, "");
        
//         return count[0];
        
//     }
// }