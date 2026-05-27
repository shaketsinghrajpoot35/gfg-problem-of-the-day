// User function Template for Java

class Solution {
    static int rotationCount(long R, long D) {
            
        
        long min = 0;
        
        while(R != 0 ){
            
            long fisrt =  R%10;
            long second = D%10;
            
             R /=10;
             D /=10;
            
            min += Math.min(Math.abs(fisrt-second), 10 - Math.abs(fisrt-second));
        }
        return (int)min;
        
    }
}