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
    public synchronized Boolean searchNode(Integer d) {
        Node ptr = root;
        while (ptr != null) {
            if (d == ((Integer)ptr.getData()).intValue()) {
                return true; 
            }
            if (d < ((Integer)ptr.getData()).intValue()) {
                ptr = ptr.getLeft();
            }
            else {
                ptr = ptr.getRight();
            }
        }
        return false;
    }

    // Delete existing node 
    public synchronized void deleteNode(Integer d) {
        Node ptr = root;
        while (ptr != null) {
            // Node is found 
            if (d == ((Integer)ptr.getData()).intValue()) {
                ptr.remove();
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
