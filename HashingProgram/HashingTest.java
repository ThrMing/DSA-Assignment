package HashingProgram;
import java.util.Scanner;
import HashingProgram.Hashing.DataStructures;

/** Class HashTableTest **/
public class HashingTest {
    private static DataStructures ds;

    public static void main(String[] args) {
        String value;
        int userInput, size;
        Scanner input = new Scanner(System.in);
        int count = 0;

        // Prompt user to enter size of hash table
        System.out.print("Enter the size of the hash table ( > 10):  ");
        size = input.nextInt();

        // Checks if input is more than 10, else repeat
        while (size <= 10) {
            if (size <= 10) {
                System.out.println("Insert any value more than 10");
                System.out.print("Enter the size of the hash table ( > 10):  ");
                size = input.nextInt();
            }
        }

        // Initializing hash tables for all data structures 
        Hashing linearHash = new Hashing(size, DataStructures.LinearProb);
        Hashing doubleHash = new Hashing(size, DataStructures.DoubleHash);
        Hashing sepchain = new Hashing(size, DataStructures.SepChain);

        /** Perform HashTable operations **/
        do {
            System.out.println("\n***********************************");
            System.out.println("\tHash Table Operations");
            System.out.println("***********************************");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Clear");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Enter your command:  ");
            userInput = input.nextInt();
            System.out.println();

            // Insertion
            if (userInput == 1) {
                do {
                    System.out.print("Insert integer value (0 to exit) : ");
                    value = input.next();
                    System.out.println("\n***************************************************************\n");
                    if (count < size) {
                        if (!(value.equals("0"))) {
                            linearHash.insertLinearProb(value);
                            System.out.println();
                            doubleHash.insertDoubleHash(value);
                            System.out.println();
                            sepchain.insertSepChain(value);
                            System.out.println();
                            count++;

                            // User is not allowed to insert value when table is full
                            if (count == size) {
                                System.out.println("Can't insert anymore because table is full");
                            }
                        }
                    } else {
                        System.out.println("Table is full");
                    }
                } while ((!(value.equals("0"))) && (count < size));
            }

            // Searching
            else if (userInput == 2) {

                do {
                    System.out.print("Search (0 to exit): ");
                    value = input.next();
                    if (!(value.equals("0"))) {
                        linearHash.searchLinearProb(value);
                        System.out.println();
                        doubleHash.searchDoubleHash(value);
                        System.out.println();
                        sepchain.searchSepChain(value);
                        System.out.println();

                    }
                } while (!(value.equals("0")));

            }

            // Clear - Remove every value inserted into the array
            else if (userInput == 3) {
                count = 0;
                linearHash.clearLinearTable();
                doubleHash.clearDoubleTable();
                sepchain.clearSeparateTable();
            }

            // Display hashtable
            else if (userInput == 4) {
                do {
                    System.out.println("***********************************");
                    System.out.println("\t       Display");
                    System.out.println("***********************************");
                    System.out.println("1. Linear Probing");
                    System.out.println("2. Double Hashing");
                    System.out.println("3. Separate Chaining");
                    System.out.println("4. Exit");
                    System.out.print("Enter a view: ");
                    userInput = input.nextInt();

                    switch (userInput) {
                        case 1:
                            linearHash.printLinearTable();
                            break;
                        case 2:
                            doubleHash.printDoubleTable();

                            break;
                        case 3:
                            sepchain.printSeparateTable();
                            break;

                        case 4:
                            System.out.println("Exiting to Main Menu");
                            break;

                        default:
                            System.out.println("Unaccepted input! Please select an option displayed onscreen!");
                            break;
                    }
                } while (userInput != 4);
            }

            else if (userInput == 5) {
                System.out.println("Thank you for using the program!");
            }

            else {
                System.out.println("Unaccepted input! Please select an option displayed onscreen!");
            }

        } while (userInput != 5);
        input.close();
    }
}