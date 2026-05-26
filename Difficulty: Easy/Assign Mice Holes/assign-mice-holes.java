class Solution {
    public int assignHole(int[] mices, int[] holes) {
        
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        int min = 0;
        
        for(int i=0;i<holes.length;i++){
            
            int timeReq = Math.abs(mices[i]-holes[i]);
            
            if(timeReq>min){
                min = timeReq;
            }
        }
        
        return min;
    }
};