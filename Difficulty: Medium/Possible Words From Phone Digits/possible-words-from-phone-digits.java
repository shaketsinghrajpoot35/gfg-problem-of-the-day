

class Solution {

    public void  backtrack(int idx, List<Integer> list, StringBuilder sb, ArrayList<String> ans, Map<Integer, String> map){

        //base case
        if(sb.length() ==list.size()){
            ans.add(sb.toString());
            return;
        }

       
        //choice
        int digit = list.get(idx);
        String choices = map.get(digit);
        

        //choice
        for(char c : choices.toCharArray()){ //['a' ,'b', 'c']

            sb.append(c); //apply
            backtrack(idx+1, list, sb,ans , map);//next choice call
            sb.deleteCharAt(sb.length()-1);

        }

    }


    public ArrayList<String> possibleWords(int[] arr) {
        
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            
            if( arr[i] >1){
                list.add(arr[i]);
            }
        }
        
        Map<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

  
        ArrayList<String> ans = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        backtrack(0, list, sb,ans , map);

        return ans;
    }
}