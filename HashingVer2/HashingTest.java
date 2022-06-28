package HashingVer2;

import java.util.Scanner;
import HashingVer2.Hashing.DataStructures;

/** Class HashTableTest **/
public class HashingTest {
    private static DataStructures ds;

    public static void main(String[] args) {
        String value;
        int userInput, size;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        size = input.nextInt();
        Hashing linearHash = new Hashing(size, DataStructures.LinearProb);
        Hashing doubleHash = new Hashing(size, DataStructures.DoubleHash);
        Hashing sepchain = new Hashing(size, DataStructures.SepChain);

        /** Perform HashTable operations **/
        do {
            System.out.println("***********************************");
            System.out.println("\tHash Table Operations");
            System.out.println("***********************************");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Clear");
            System.out.println("4. Exit");
            System.out.print("Enter your command:  ");
            userInput = input.nextInt();

            // Insertion
            if (userInput == 1) {
                do {
                    System.out.print("Insert(0 to exit) : ");
                    value = input.next();
                    if (!(value.equals("0"))) {
                        linearHash.insertLinearProb(value);
                        doubleHash.insertDoubleHash(value);
                        sepchain.insertSepChain(value);

                    }
                } while (!(value.equals("0")));

            }

            // Searching
            else if (userInput == 2) {
                do {

                    System.out.print("Search(0 to exit) : ");
                    value = input.next();
                    if (!(value.equals("0"))) {
                        linearHash.searchValue(value);

                    }
                } while (!(value.equals("0")));
            }

            // Clear - Remove every value inserted into the array
            else if (userInput == 3) {
                linearHash.clearLinearTable();
                doubleHash.clearDoubleTable();
                sepchain.clearSeparateTable();
            }

            else if (userInput == 4) {
                System.out.println("Goodbye");
            }

            else {
                System.out.println("Wrong Entry");
            }

            /** Display hash table **/
            linearHash.printLinearTable();
            doubleHash.printDoubleTable();
            sepchain.printSeparateTable();

        } while (userInput != 4);
        input.close();
    }

}