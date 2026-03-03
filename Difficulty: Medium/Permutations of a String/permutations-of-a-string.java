class Solution {
    
    public void  backtrack(char []arr,boolean []visited,ArrayList<String> ans,StringBuilder currPerm){
        
        if(currPerm.length() == arr.length){
            ans.add(currPerm.toString());
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            
            
            //if 
            if(visited[i]){
                continue;
            }
            
            if(i>0 && arr[i-1]==arr[i] && visited[i-1]==false){
                continue;
            }
            
            visited[i] = true;
            currPerm.append(arr[i]);
            
            backtrack(arr,visited,ans,currPerm);
            
            visited[i] = false;
            currPerm.delete(currPerm.length()-1,currPerm.length());
            
            
        }
    }
    
    
    
    public ArrayList<String> findPermutation(String s) {
        
        char[] arr = s.toCharArray();
        Arrays.sort(arr); 
        
        boolean visited[] = new boolean[arr.length];
        ArrayList<String> ans = new ArrayList<String>();
        
        backtrack(arr,visited,ans,new StringBuilder());
        
        
        return ans;
        
    }
}