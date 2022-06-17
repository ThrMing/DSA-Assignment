public class BinaryTree {
    protected Node root;

    // Constructor
    // Empty tree
    public BinaryTree() {
        root = null;
    }

    // Insert new node
    public synchronized void insertNode(Integer value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    // Search node
    public synchronized Boolean searchNode(Integer value) {
        Node ptr = root;
        while (ptr != null) {
            if (value == ((Integer) ptr.getData()).intValue()) {
                return true;
            }
            if (value < ((Integer) ptr.getData()).intValue()) {
                ptr = ptr.getLeft();
            } else {
                ptr = ptr.getRight();
            }
        }
        return false;
    }

    // Delete existing node
    public synchronized void deleteNode(Integer value) {
        Node ptr = root;
        while (ptr != null) {
            // Node is found
            if (value == ((Integer) ptr.getData()).intValue()) {
                ptr.remove();
            }

            // If Node is smaller, go left child
            if (value < ((Integer) ptr.getData()).intValue()) {
                ptr = ptr.getLeft();
            }
            // If Node is larger, go right child
            else {
                ptr = ptr.getRight();
            }
        }
    }

    // To display the tree
    public void displayer(Node node, String spacing, boolean check) {
        Node ptr = root;
        // Check if the root is empty
        if (ptr == null) {
            System.out.println("The Tree is empty");
        }
        // Check if the null is empty
        // Making sure that the root has no spacing when printed out if it is empty
        if (node != null) {
            System.out.print(spacing);
            // if "check" is true, check node.right in the tree and print
            if (check) {
                System.out.print("R----");
                spacing += "|    ";
                System.out.print(node.data + "\n");

                // if "check" is false, check node.left in the tree and print
            } else {
                System.out.print("L----");
                spacing += "|    ";
                System.out.print(node.data + "\n");

            }

            // Recursion, each time check left and then right
            displayer(node.left, spacing, false);
            displayer(node.right, spacing, true);
        }

    }

    // Preorder Traversal
    public void preorderTraversal() {
        preorderHelper(root);
    }

    // Recursive method to perform preorder traversal
    private void preorderHelper(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " - ");
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    // Inorder Traversal
    public void inorderTraversal() {
        inorderHelper(root);
    }

    // Recursive method to perform inorder traversal
    private void inorderHelper(Node node) {
        if (node == null)
            return;

        inorderHelper(node.left);
        System.out.print(node.data + " - ");
        inorderHelper(node.right);
    }

    // Postorder Traversal
    public void postorderTraversal() {
        postorderHelper(root);
    }

    // Recursive method to perform postorder traversal
    private void postorderHelper(Node node) {
        if (node == null)
            return;

        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.print(node.data + " - ");
    }

}
