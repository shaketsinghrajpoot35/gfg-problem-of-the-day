class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int a: arr) set.add(a*a);
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int curr = (arr[i]*arr[i]) + (arr[j]*arr[j]);
                if(set.contains(curr)) return true;
            }
        }
        return false ;
        
    }
}