import java.util.Scanner;

public class BSTtest {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int userInput, value;
        BinaryTree t = new BinaryTree();

        do {
            System.out.println("");
            asterisk();
            System.out.println("\t\tBinary Search Tree");
            asterisk();
            System.out.println("1. Play");
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
                    userInput = input.nextInt();

                    // Insert
                    if (userInput == 1) {
                        do {
                            System.out.print("Insert value(0 to exit): ");
                            value = input.nextInt();
                            if (value != 0) {
                                t.insertNode(value);

                            }
                        } while (value != 0);
                        System.out.println("");
                        t.displayer(t.root, "", true);

                    }

                    // Delete
                    else if (userInput == 2) {
                        System.out.print("Delete value: ");
                        value = input.nextInt();
                        t.deleteNode(value);
                        System.out.println("");
                        t.displayer(t.root, "", true);

                    }

                    // Search
                    else if (userInput == 3) {
                        do {
                            System.out.print("Search value(0 to exit): ");
                            value = input.nextInt();
                            if (value != 0) {
                                System.out.println(t.searchNode(value));
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

            else if (userInput == 2) {
                t.preorderTraversal();
            }

            else if (userInput == 3) {
                t.inorderTraversal();
            }

            else if (userInput == 4) {
                t.postorderTraversal();
            }

            else if (userInput == 5) {
                System.out.println("");
                t.displayer(t.root, "", true);
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

    public static void asterisk() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}