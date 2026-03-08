

class Solution {


    public Node recursionReverseList(Node prev, Node curr){

        if(curr == null){
            return prev;
        }

        Node temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;

        return recursionReverseList( prev,curr);


    }

    Node reverseList(Node head) {
        
        Node prev = null;
        return recursionReverseList(prev, head);

       
    }
}