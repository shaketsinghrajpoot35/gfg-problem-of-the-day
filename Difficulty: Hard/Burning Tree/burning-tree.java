/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    public void parentPointer(Node root,int target,Node targetNode[],HashMap<Node,Node> map){
        
        if(root == null){
            return ;
        }
        
        
        // if(root.left == null && root.right == null){
        //     return;
        // }
        
        if(root.data == target){
            targetNode[0] = root;
        }
        
        if(root.left != null){
            map.put(root.left , root);
            parentPointer(root.left,target,targetNode, map);
        }
        
        if(root.right != null){
            map.put(root.right , root);
            parentPointer(root.right,target,targetNode, map);
        }

    }        
    
    public int minTime(Node root, int target) {
        
        if(root == null){
            return 0;
        }
        
        
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        Node targetNode[] = new Node[1];
        parentPointer(root,target,targetNode, map);
        
        if(targetNode[0] == null){
            return 0;
        }
        
        Set<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode[0]);
        
        int count = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0; i<size;i++){
                
                Node node = q.remove();
                
                set.add(node);
                
                if(node.left != null && !set.contains(node.left)){
                    set.add(node.left);
                    q.add(node.left);
                }
                
                if(node.right != null && !set.contains(node.right)){
                    set.add(node.right);
                    q.add(node.right);
                }
                
                if(map.containsKey(node) && map.get(node) != null && !set.contains(map.get(node))){
                    set.add(map.get(node));
                    q.add(map.get(node));
                }
                
            }
            
            count++;
        }
        
        return count-1;
    }
}