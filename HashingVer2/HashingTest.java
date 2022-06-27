package HashingVer2;

import java.util.Scanner;

/** Class HashTableTest **/
public class HashingTest {
    public static void main(String[] args) {
        String key;
        int userInput, size;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        size = input.nextInt();
        // Hashing table = new Hashing(size);

        /** Perform HashTable operations **/
        do {
            System.out.println("***********************************");
            System.out.println("\tHash Table Operations");
            System.out.println("***********************************");
            System.out.println("1. insert(K,V) ");
            System.out.println("2. get(K) ");
            System.out.println("3. contain(K) ");
            System.out.println("4. clear");
            System.out.println("5. Exit");
            System.out.print("Enter your command:  ");
            userInput = input.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("\n   Key = ");
                    key = input.next();
                    // table.insert(key);
                    break;

                case 2:
                    System.out.println("\n   Key = ");
                    // key = TextIO.getln(
                    // System.out.println(" Value is " + table.get(key));
                    break;

                case 3:
                    System.out.println("\n   Key = ");
                    // key = TextIO.getln(
                    // System.out.println(" containsKey(" + key + ") is "
                    // + table.containsKey(key));
                    break;

                case 4:
                    // table.clear();
                    System.out.println("Hash Table Cleared\n");
                    break;

                case 5:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            /** Display hash table **/
            // table.printTable();

        } while (userInput != 5);
        input.close();
    }

}