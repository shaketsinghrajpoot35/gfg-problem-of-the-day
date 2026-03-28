

class Solution {

    public boolean isValidParenthesis(String s){

        int c = 0;
        for(char ch : s.toCharArray()){

            if(ch =='('){
                c++;
            }

            else if(ch == ')'){
                c--;
            }

            if(c<0){
                return false;
            }
        }

        return c==0;
    }

     public ArrayList<String> generateParentheses(int n) {
        
        ArrayList<String> ans = new ArrayList<>();
        
        Queue<String> q = new LinkedList<>();
        q.add("");

        while(!q.isEmpty()){

            String curr = q.remove();
            if(curr.length() == n){

                if(isValidParenthesis(curr)){
                    ans.add(curr);
                }

                continue;
            }

            q.add(curr+"(");
            q.add(curr+")");
        }

        return ans;
    }
}