// class Solution {
//     static boolean canAttend(int[][] arr) {
       
//       Arrays.sort(arr, (a,b)->a[0]-b[0]);
       
//       for(int i=1;i<arr.length;i++){
           
//           if(arr[i-1][1] > arr[i][0]){
//               return false;
//           }
//       }
        
//         return true;
//     }
// }

class Solution {
    static boolean canAttend(int[][] arr) {
       
       Map<Integer,Integer> treeMap = new TreeMap<>();
       
       for(int[] meeting : arr){
           
           int start = meeting[0],
               end = meeting[1];
           treeMap.put(start,treeMap.getOrDefault(start,0)+1);
           treeMap.put(end,treeMap.getOrDefault(end,0)-1);
           
       }
       
       int requireRoom =0 ;
       for(Map.Entry<Integer,Integer> pair : treeMap.entrySet()){
           
           requireRoom += pair.getValue();
           if(requireRoom>1){
               return false;
           }
       }
       
       return true;
       
    }
}