

public class BSTtest {
    public static void main( String args[] ) {
        BinaryTree tree = new BinaryTree();

        System.out.println("Inserting the following values: ");

        tree.insertNode(12);
        tree.insertNode(4);
        tree.insertNode(8);
        tree.insertNode(20);
        tree.insertNode(23);
        tree.deleteNode(4);
        tree.deleteNode(12);

        System.out.println(tree.searchNode(12));
        System.out.println(tree.searchNode(4));
        System.out.println(tree.searchNode(8));


    }
}