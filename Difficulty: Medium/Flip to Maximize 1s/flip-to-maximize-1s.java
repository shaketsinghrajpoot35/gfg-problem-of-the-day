class Solution {
    int maxOnes(int[] arr) {
        // code here
        int oneCnt =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==1){
                arr[i]=-1;
                oneCnt++;
            }else{
                arr[i]=1;
            }
        }
        
        //kadane's algorithm
        int ans =0;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            ans =Math.max(ans, sum);
            if(sum<0){
                sum=0;
            }
            
        }
        return ans +oneCnt;
    }
};

