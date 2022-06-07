public class BinaryTree {
    protected Node root;

    // Constructor
    // Empty tree 
    public BinaryTree() {
        root = null;
    }
    
    // Insert new node 
    public synchronized void insertNode( Integer d ) {
        if (root == null) {
            root = new Node(d);
        }
        else {
            root.insert(d);
        }
    }

    // Search node 
    public synchronized Object searchNode(Integer d) {
        Node ptr = root;
        while (ptr != null) {
            if (d == ((Integer)ptr.getData()).intValue()) {
                return ptr.data; 

            }
            if (d < ((Integer)ptr.getData()).intValue()) {
                ptr = ptr.getLeft();
            }
            else {
                ptr = ptr.getRight();
            }
        }
        return null;
    }

    // Delete existing node 
    public synchronized void deleteNode(Integer d) {
        boolean nodeFound = false;
        Node ptr = root;
        while (nodeFound != true) {
            // Node is found 
            if (d == ((Integer)ptr.getData()).intValue()) {
                // Leaf node 
                if ((ptr.left == null) && (ptr.right == null)) {
                    ptr = null;
                }
                // One child (left) OR have both children 
                else if ((ptr.right == null) || ((ptr.left != null) && (ptr.right != null))) {
                    ptr = ptr.left;
                    ptr.left = null;
                }
                // One child (right)
                else if (ptr.left == null) {
                    ptr = ptr.right;
                    ptr.right = null;
                }
            }

            // If Node is smaller, go left child 
            if (d < ((Integer)ptr.getData()).intValue()) {
                ptr = ptr.getLeft();
            }
            // If Node is larger, go right child 
            else {
                ptr = ptr.getRight();
            }
        } 
    }

}
