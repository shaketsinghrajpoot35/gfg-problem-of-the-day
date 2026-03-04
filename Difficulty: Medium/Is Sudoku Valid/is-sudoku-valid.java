
class Solution {


    public static boolean backtrack(int[][] board, List<HashSet<Integer>> rows, List<HashSet<Integer>> cols, List<HashSet<Integer>> boxes){

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board.length;j++){
                
                int cell = board[i][j];
                if(cell == 0){
                    continue;
                }

                if(rows.get(i).contains(cell)){
                    return false;
                }

                if(cols.get(j).contains(cell)){
                    return false;
                }

                int boxIndex = 3 * (i/3)+(j/3);
                if(boxes.get(boxIndex).contains(cell)){
                    return false;
                }

                rows.get(i).add(cell);
                cols.get(j).add(cell);
                boxes.get(boxIndex).add(cell);
            }
        }

        return true;
    }


    static boolean isValid(int board[][]) {
        
        List<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        List<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>();
        List<HashSet<Integer>> boxes = new ArrayList<HashSet<Integer>>();

        for(int i=0;i<board.length;i++){

            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());

        }

        return backtrack(board, rows, cols, boxes);

    }
}