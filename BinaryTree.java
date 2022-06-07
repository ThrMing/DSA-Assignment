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
        Node ptr = root;
        while (ptr != null) {
            if (d == ((Integer)ptr.getData()).intValue()) {
                // Node is found
                ptr.remove();
            }
            if (d < ((Integer)ptr.getData()).intValue()) {
                ptr = ptr.getLeft();
            }
            else {
                ptr = ptr.getRight();
            }
        } 
    }

}
