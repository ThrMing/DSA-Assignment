package HashingVer2;

public class Hashing {

    private int count = 0;
    private int maxSize;
    private String[] table;

    public Hashing(int capacity) {
        // Create a hash table with a specified initial size.
        table = new String[capacity];

    }

    public void clearTable() {
        for (int i = 0; i < table.length; i++) {
            table[i] = "null";
        }
    }

    public void printTable() {
        System.out.println("Hash Table: ");
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
            count++;
            if (count == 10) {
                count = 0;
                System.out.println();
            }
        }
        System.out.println();
    }

}
