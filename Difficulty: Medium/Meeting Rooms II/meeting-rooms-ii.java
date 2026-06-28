class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int i=0;i<start.length;i++){
            
            int s1 = start[i],
                e1 = end[i];
            
            map.put(s1,map.getOrDefault(s1,0)+1);
            map.put(e1,map.getOrDefault(e1,0)-1);
        }
        
        int maxRoomRequire = 0;
        
        int currentReqRoom = 0;
        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            
            currentReqRoom += pair.getValue();
            maxRoomRequire = Math.max(currentReqRoom,maxRoomRequire);
            
        }
        
        return maxRoomRequire;
        
    }
}
