package BST;

public class Node {

    protected Node left, right;
    protected Object data; 

    // Constructor 
    public Node( Object newData ) {
        data = newData;
        left = right = null;
    }

    // Insertion (Recursion)
    public synchronized void insert( Integer n ) {

        // If value is same as node data 
        // Go right or insert right child
        if (n.intValue() == ((Integer) data).intValue()) {
            if(right == null) {
                right = new Node(n);
            }
            else {
                right.insert(n);
            }
        }

        // If value is less than node data
        // Go left or insert left child  
        if ( n.intValue() < ((Integer) data).intValue() ) {
            if (left == null ) {
                left = new Node(n);
            }
            else {
                left.insert(n);
            }
        }

        // Else, If value is more than node data
        // Go right or insert right child 
        else if (n.intValue() >= ((Integer) data ).intValue()) {
            if (right == null) {
                right = new Node(n);
            }
            else {
                right.insert(n);
            }
        }
    }

    // Deletion
    public synchronized void remove() {
        // Leaf node 
        if ((left == null) && (right == null)) {
            data = 0;
        }
        // One child (left) OR have both children 
        else if ((right == null) || ((left != null) && (right != null))) {
            data = left.data;
            left = left.left;
        }
        // One child (right)
        else if (left == null) {
            data = right.data;
            right = right.right;
        }
    }

    // Get right child 
    public synchronized Node getRight() {
        return right;
    }
    // Get left child 
    public synchronized Node getLeft() {
        return left; 
    }
    // Get data 
    public synchronized Object getData() {
        return data;
    }
}
