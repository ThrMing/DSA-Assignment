package HashingVer2;

import java.util.Scanner;

/** Class HashTableTest **/
public class HashingTest {
    public static void main(String[] args) {
        String value;
        int userInput, size;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        size = input.nextInt();
        //Hashing table = new Hashing(size);

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
                    System.out.print("Insert(0 to exit) : "); // value = user input while key =index
                    value = input.next();

                } while (!(value.equals("0")));
            }

            // Searching
            else if (userInput == 2) {
                do {

                    System.out.print("Search(0 to exit) : ");
                    value = input.next();

                } while (!(value.equals("0")));
            }

            // Clear - Remove every value inserted into the array
            else if (userInput == 3) {
                // table.clearTable();
            }

            else if (userInput == 4) {
                System.out.println("Goodbye");
            }

            else {
                System.out.println("Wrong Entry");
            }

            /** Display hash table **/
            // table.printTable();
        } while (userInput != 4);
        input.close();
    }

}