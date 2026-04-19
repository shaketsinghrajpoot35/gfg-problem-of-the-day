// Java Code.......
class Solution {
    public boolean isPower(int x, int y) {        
        if(x==1 || x==0)    return false;
        
        for(int i=0; i<=1000; i++){
            int pow = (int)Math.pow(x, i);
            if(pow==y)  return true;
            if(pow>y)   return false;
        }
        return false;
    }
}