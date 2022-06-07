

public class BSTtest {
    public static void main( String args[] ) {
        BinaryTree tree = new BinaryTree();

        System.out.println("Inserting the following values: ");

        tree.insertNode(12);
        tree.insertNode(4);
        tree.insertNode(8);
        tree.insertNode(20);
        tree.insertNode(23);

        System.out.println("Search for 4: " + tree.searchNode(5));



    }
}