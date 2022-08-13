import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();
    //Stored old node as key and value as newNode in parallel with it from new LL
    public Node getClonedNode(Node curr){

        if(curr != null){
            //Check if node is in the visisted dictionary
            if(this.visited.containsKey(curr)){
                return this.visited.get(curr);
            }
            else{
                //Otherwise create a new Node, add to visited and return it
                this.visited.put(curr, new Node(curr.val, null, null));
                return this.visited.get(curr);
            }
        }

        return null;
    }
    
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
            
        Node oldNode = head;

        //Creating new head
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        //Iterate on the linked List until all nodes are clones

        while(oldNode != null){
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            //Move one step ahead in both linked List
            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return this.visited.get(head);
    }
}