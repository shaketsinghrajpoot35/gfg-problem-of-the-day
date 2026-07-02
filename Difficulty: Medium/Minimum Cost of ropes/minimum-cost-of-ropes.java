class Solution {
    public static int minCost(int[] arr) {
        
        int len = arr.length;
        
        PriorityQueue<Integer> minRopesHeap = new PriorityQueue<>();
        
        for(int ropeLen : arr){
            minRopesHeap.add(ropeLen);
        }
        
        int counter = 1;
        int minTotalCost = 0;
        while(counter<=len-1){
            
            int firstMinRope = minRopesHeap.poll(),
                 secondMinRope = minRopesHeap.poll();
            
            minTotalCost += (firstMinRope + secondMinRope);
            
            minRopesHeap.add(firstMinRope + secondMinRope);
            
            counter++;
        }
        
        return minTotalCost;
        
    }
}