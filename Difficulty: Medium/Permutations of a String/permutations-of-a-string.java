class Solution {
    
    public void  backtrack(String s, Set<String>set, List<Integer> map, StringBuffer str){
        
        
        //base case
        if(str.length()==s.length()){
            
            set.add(str.toString());
            return;
        }
        
        //choise
        for(int i=0;i<s.length();i++){
            
            if(!map.contains(i)){
                
                str.append(s.charAt(i));
                map.add(i);
                
                backtrack(s,set,map,str);
                
                str.delete(str.length()-1,str.length());
                map.remove(map.size()-1);
                 
                
            }
        }
    }
    
    
    
    public ArrayList<String> findPermutation(String s) {
        
        Set<String> set = new HashSet<String>();
        List<Integer> map = new ArrayList<Integer>();
        
        StringBuffer str = new StringBuffer();
        
        backtrack(s,set,map,str);
        
        
        ArrayList<String>  ans = new ArrayList<>(set);
        return ans;
        
    }
}