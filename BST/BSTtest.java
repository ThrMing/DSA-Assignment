package BST;
import java.util.Scanner;

public class BSTtest {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int userInput, value;
        BinaryTree tree = new BinaryTree();

        do {
            System.out.println("");
            asterisk();
            System.out.println("\t\tBinary Search Tree");
            asterisk();
            System.out.println("1. Insert data");
            System.out.println("2. Preorder");
            System.out.println("3. Inorder");
            System.out.println("4. Postorder");
            System.out.println("5. Display Tree");
            System.out.println("6. Exit");
            System.out.print("Choose 1 ~ 6: ");
            userInput = input.nextInt();

            if (userInput == 1) {
                while (userInput != 4) {
                    System.out.println("");
                    asterisk();
                    System.out.println("\t\t     Welcome");
                    asterisk();
                    System.out.println("1. Insert");
                    System.out.println("2. Delete");
                    System.out.println("3. Search");
                    System.out.println("4. Exit");
                    System.out.print("Select an option: ");
                    userInput = input.nextInt();

                    // Insert
                    if (userInput == 1) {
                        do {
                            System.out.print("Insert value(0 to exit): ");
                            value = input.nextInt();
                            if (value != 0) {
                                tree.insertNode(value);

                            }
                        } while (value != 0);
                        System.out.println("");
                        tree.print_tree();
                    }

                    // Delete
                    else if (userInput == 2) {
                        System.out.print("Delete value: ");
                        value = input.nextInt();
                        tree.deleteNode(value);
                        System.out.println("");
                        tree.print_tree();

                    }

                    // Search
                    else if (userInput == 3) {
                        do {
                            System.out.print("Search value(0 to exit): ");
                            value = input.nextInt();
                            if (value != 0 && tree.searchNode(value)){
                                System.out.println("\nThe value exists in the tree.\nTo view the location of the value, return to the main menu and select the function 'Display Tree.'\n");
                            }
                            else if (value != 0 && !tree.searchNode(value)){
                                System.out.println("\nThe value does not exist in the tree.\n");
                            }
                        } while (value != 0);

                    }

                    else if (userInput == 4) {
                        System.out.println("Returning to main page");
                    }

                    else {
                        System.out.println("input 1 to 4 only");
                    }
                }
            }

            // Input options for tree traversals
            else if (userInput == 2) {
                tree.preorderTraversal();
            }

            else if (userInput == 3) {
                tree.inorderTraversal();
            }

            else if (userInput == 4) {
                tree.postorderTraversal();
            }

            else if (userInput == 5) {
                System.out.println("");
                tree.print_tree();
            }

            else if (userInput == 6) {
                System.out.println("Exiting");
            }

            else {
                System.out.println("Input 1 to 6 only");
            }
        } while (userInput != 6);
        input.close();
    }

    // Prints out asterisk line for user interface
    public static void asterisk() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}