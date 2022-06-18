import java.util.Scanner;

public class BSTtest {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int userInput, value;
        BinaryTree t = new BinaryTree();
        asterisk();
        System.out.println("\t\tBinary Search Tree");
        asterisk();

        do {
            // asterisk();
            // System.out.println("\t\tBinary Search Tree");
            // asterisk();
            System.out.println("\n1. Play");
            System.out.println("2. Preorder");
            System.out.println("3. Inorder");
            System.out.println("4. Postorder");
            System.out.println("5. Display Tree");
            System.out.println("6. Exit");
            System.out.print("\nChoose 1 ~ 6: ");
            userInput = input.nextInt();

            if (userInput == 1) {
                System.out.println();
                asterisk();
                System.out.println("\t\t     Welcome");
                asterisk();
                while (userInput != 4) {
                    System.out.println("\n1. Insert");
                    System.out.println("2. Delete");
                    System.out.println("3. Search");
                    System.out.println("4. Exit");
                    System.out.print("\nChoose 1 ~ 4: ");
                    userInput = input.nextInt();

                    // Insert
                    if (userInput == 1) {
                        System.out.println();
                        asterisk();
                        System.out.println("\t\t    Insertion");
                        asterisk();
                        do {
                            System.out.print("Insert value(0 to exit): ");
                            value = input.nextInt();
                            if (value != 0) {
                                t.insertNode(value);

                            }
                        } while (value != 0);
                        System.out.println("");
                        asterisk();
                        System.out.println();
                        t.displayer(t.root, "", true);
                        System.out.println();
                        asterisk();

                    }

                    // Delete
                    else if (userInput == 2) {
                        System.out.println();
                        asterisk();
                        System.out.println("\t\t    Deletion");
                        asterisk();
                        System.out.print("Delete value: ");
                        value = input.nextInt();
                        t.deleteNode(value);
                        System.out.println("");
                        asterisk();
                        t.displayer(t.root, "", true);
                        asterisk();

                    }

                    // Search
                    else if (userInput == 3) {
                        System.out.println();
                        asterisk();
                        System.out.println("\t\t    Searching");
                        asterisk();
                        do {
                            System.out.print("Search value(0 to exit): ");
                            value = input.nextInt();
                            if (value != 0) {
                                System.out.println(t.searchNode(value));
                            }
                        } while (value != 0);
                        System.out.println();
                        asterisk();
                        System.out.println("\t\t     Welcome");
                        asterisk();
                    }

                    else if (userInput == 4) {
                        System.out.println();
                        asterisk();
                        System.out.println("\t\tBinary Search Tree");
                        asterisk();
                    }

                    else {
                        System.out.println();
                        asterisk();
                        System.out.println("\t Incorrect Input, Please Retry");
                        asterisk();
                    }
                }
            }

            else if (userInput == 2) {
                System.out.println();
                asterisk();
                System.out.println("\t\t    PreOrder");
                asterisk();
                System.out.println();
                t.preorderTraversal();
                System.out.println();
            }

            else if (userInput == 3) {
                System.out.println();
                asterisk();
                System.out.println("\t\t    InOrder");
                asterisk();
                System.out.println();
                t.inorderTraversal();
                System.out.println();
            }

            else if (userInput == 4) {
                System.out.println();
                asterisk();
                System.out.println("\t\t    PostOrder");
                asterisk();
                System.out.println();
                t.postorderTraversal();
                System.out.println();
            }

            else if (userInput == 5) {
                System.out.println("");
                asterisk();
                System.out.println();
                t.displayer(t.root, "", true);
                System.out.println();
                asterisk();
            }

            else if (userInput == 6) {
                System.out.println();
                asterisk();
                System.out.println("\t\t   Thank you");
                asterisk();
            }

            else {
                System.out.println();
                asterisk();
                System.out.println("\t Incorrect Input, Please Retry");
                asterisk();
            }

        } while (userInput != 6);
        input.close();
    }

    public static void asterisk() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}