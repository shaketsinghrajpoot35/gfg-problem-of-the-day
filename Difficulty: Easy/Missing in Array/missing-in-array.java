

// class Solution {
//     int missingNum(int arr[]) {
        
//         int n = arr.length+1;
//         double sum = Arrays.stream(arr).sum(); 
//         return (int) ( n*(n+1)/2 -sum);
        
//     }
// }

class Solution {

    public void swap(int arr[], int first, int second){

        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public int  missingNum(int[] nums) {
       
       int i = 0;
       int n = nums.length;

       while(i<n){

          int correct_idx = nums[i]-1;

          if(correct_idx>= n){
            i++;
          }

          else if(nums[i] != nums[correct_idx]){

              //swap i and correct_idx
              swap(nums,i,correct_idx);
          } else{

            i++;
          }
       }

       for( int j=0;j<n;j++){

        if(nums[j]-1 != j){
            return j+1;
        }
       }

       return n+1;
    }
 
}
