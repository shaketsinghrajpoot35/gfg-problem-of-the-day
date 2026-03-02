
class Solution {

    public void backtracking(int start, int n, int k, 
                            ArrayList<ArrayList<Integer>> combinations, 
                             ArrayList<Integer> list,int sum) {

        // Base Case
        if (list.size() == k && sum == n ) {
            combinations.add(new ArrayList<>(list));
            return;
        }

        // Loop from start to n
        // int remaining = k - list.size();
        for (int i = start; i <= 9; i++) {

            list.add(i);  // choose
            sum +=i;

            backtracking( i+ 1, n, k, combinations, list,sum);  // explore

            list.remove(list.size() - 1);  // un-choose (backtrack)
            sum -=i;
        }
    }

   public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {

        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();

        backtracking(1, n, k, combinations, new ArrayList<>(),0);

        return combinations;
    }
}