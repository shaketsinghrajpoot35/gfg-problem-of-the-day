/*class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    } */


class Solution {

    // Ye function recursion se pairwise nodes ko swap karta hai
    public void recursion(Node fistNode, Node secondNode){

        // Agar kisi bhi node par null mil gaya to swap possible nahi hai
        if(fistNode == null || secondNode == null){
            return;
        }

        // Dono nodes ke values ko swap kar rahe hain
        int temp = fistNode.data;
        fistNode.data = secondNode.data;
        secondNode.data = temp;

        // Ab next pair ke liye move karna hai

        // secondNode ke baad wala node next pair ka first node banega
        fistNode = secondNode.next;

        // Agar list yahi khatam ho gayi (odd length case) to recursion stop
        if(fistNode == null) return;

        // Next pair ka second node
        secondNode = fistNode.next;

        // Recursively next pair swap kar do
        recursion(fistNode,secondNode);

    }
    
    public Node pairwiseSwap(Node head) {

        // Agar list empty hai ya sirf ek node hai to swap ki need nahi
        if(head == null || head.next == null){
            return head;
        }

        // Recursion start kar rahe hain first do nodes se
        recursion(head,head.next);

        // Head same rahega kyunki hum values swap kar rahe hain
        return head;
    }
}