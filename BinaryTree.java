public class BinaryTree {
    protected Node root;

    // Constructor
    // Empty tree
    public BinaryTree() {
        root = null;
    }

    // Insert new node
    public synchronized void insertNode(Integer d) {
        if (root == null) {
            root = new Node(d);
        } else {
            root.insert(d);
        }
    }

    // Search node
    public synchronized Boolean searchNode(Integer d) {
        Node ptr = root;
        while (ptr != null) {
            if (d == ((Integer) ptr.getData()).intValue()) {
                return true;
            }
            if (d < ((Integer) ptr.getData()).intValue()) {
                ptr = ptr.getLeft();
            } else {
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
            if (d == ((Integer) ptr.getData()).intValue()) {
                ptr.remove();
            }

            // If Node is smaller, go left child
            if (d < ((Integer) ptr.getData()).intValue()) {
                ptr = ptr.getLeft();
            }
            // If Node is larger, go right child
            else {
                ptr = ptr.getRight();
            }
        }
    }

    public void displayer(Node node, String indent, boolean last) {

        if (root == null) {
            System.out.println("The Tree is empty");
        }
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "|    ";

            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            System.out.print(node.data + "\n");
            displayer(node.left, indent, false);
            displayer(node.right, indent, true);
        }

    }

    public void print_tree() {
        // calling displayer from TreeNode
        displayer(root, "", true);
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
