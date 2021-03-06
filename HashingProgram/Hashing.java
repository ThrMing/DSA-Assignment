package HashingProgram;
import java.util.LinkedList;

public class Hashing {
    String[] DoubleHashTable;
    String[] LinearProbTable;
    LinkedList<String>[] SCHashTable;
    int arrSize;
    int count = 0;

    // Constructor
    public Hashing(int n, DataStructures ds) {
        // Create hash tables for each data structure
        arrSize = n;
        switch (ds) {
            case LinearProb:
                LinearProbTable = new String[n];
                break;
            case DoubleHash:
                DoubleHashTable = new String[n];
                break;
            case SepChain:
                SCHashTable = new LinkedList[n];
                break;
        }
    }    

    // Insertion for Linear Probing data structure
    public void insertLinearProb(String w) {
        int hashValue = HashFunction(w);
        int index = hashValue % arrSize;
        boolean notStored = true;

        // Loop through to each index of the hash table to check if it is empty
        // If position is empty, insert value
        // If collision happens, go to the next position
        while (notStored) {
            if (index == (arrSize - 1) && LinearProbTable[index] != null) {
                index = 0;
            }
            if (LinearProbTable[index] == null) {
                LinearProbTable[index] = w;
                notStored = false;
                System.out.println("[Linear Probing] Inserted at index " + index);
            } else {
                System.out.println("[Linear Probing] Collision happens at index " + index);
                index++;
            }
        }
    }

    // Searching for Linear Probing data structure
    public void searchLinearProb(String w) {
        int indexes[] = new int[arrSize];
        int x = 0;

        for (int i = 0; i < arrSize; i++) {
            if (w.equals(LinearProbTable[i])) {
                indexes[x] = i;
                x++;
            }
        }

        // If value does not exist
        if (indexes[0] == 0 && indexes[1] == 0) {
            System.out.println("\n[Linear Probing] Value does not exist.");
        } else {
            System.out.print("\n[Linear Probing] Value: " + w + ", Index: ");
            for (int i = 0; i < indexes.length; i++) {
                System.out.print(indexes[i] + ", ");
                if (indexes[i + 1] == 0) {
                    break;
                }
            }
            System.out.println("");
        }
    }

    // Get prime number to calculate step size for double hashing
    public int getPrime() {
        for (int i = arrSize - 1; i >= 1; i--) {
            int f = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    f++;
                }
            }
            if (f == 0) {
                return i;
            }
        }
        return 3;
    }

    // Insertion for Double Hashing data structure
    public void insertDoubleHash(String w) {
        int hashValue = HashFunction(w);
        int constant = getPrime();
        int index = hashValue % arrSize;
        int stepSize = constant - (hashValue % constant);
        boolean notStored = true;

        // Loop through to each index of the hash table to check if it is empty
        // If position is empty, insert value
        // If collision happens, jump several positions based on stepSize variable
        while (notStored) {
            if (index == (arrSize - 1) && DoubleHashTable[index] != null) {
                index = 0;
            }
            if (DoubleHashTable[index] == null) {
                DoubleHashTable[index] = w;
                notStored = false;
                System.out.println("[Double Hashing] Inserted at index " + index);

            } else {
                System.out.println("\n[Double Hashing] Collision happens at index " + index);
                index += stepSize;
                index %= arrSize;
            }
        }
    }

    // Search method for Double Hashing data structure
    public void searchDoubleHash(String w) {
        int indexes[] = new int[arrSize];
        int x = 0;

        for (int i = 0; i < arrSize; i++) {
            if (w.equals(DoubleHashTable[i])) {
                indexes[x] = i;
                x++;
            }
        }

        // If value does not exist 
        if (indexes[0] == 0 && indexes[1] == 0) {
            System.out.println("\n[Double Hashing] Value does not exist.");
        } else {
            System.out.print("\n[Double Hashing] Value: " + w + ", Index: ");
            for (int i = 0; i < indexes.length; i++) {
                System.out.print(indexes[i] + ", ");
                if (indexes[i + 1] == 0) {
                    break;
                }
            }
            System.out.println("");
        }
    }

    // Insertion for Separate Chaining data structure
    public void insertSepChain(String w) {
        int hashValue = HashFunction(w);
        int index = hashValue % arrSize;

        // Loop through to each index of the hash table to check if it is empty
        // If position is empty, create another linked list within and insert value
        // If collision happens, insert value to the list within the linked list
        if (SCHashTable[index] == null) {
            SCHashTable[index] = new LinkedList<String>();
            SCHashTable[index].add(w);
            System.out.println("[SeparateChaining] Inserted at index " + index);
            System.out.println("\n***************************************************************\n");
        } else {
            SCHashTable[index].add(w);
            System.out.println("\n[Separate Chaining] Collision happens at index " + index);
            System.out.println("[Separate Chaining] Inserted into linked list at index " + index);
            System.out.println("\n***************************************************************\n");
        }
    }

    // Search method for Separate Chaining data structure
    public void searchSepChain(String w) {
        int indexes[] = new int[arrSize];

        for (int x = 0; x < arrSize; x++) {
            if (SCHashTable[x] == null) {
                continue;
            }
            for (int y = 0; y < SCHashTable[x].size(); y++) {
                if (w.equals(SCHashTable[x].get(y))) {
                    indexes[0] = x;
                }
            }
        }

        // If value does not exist
        if (indexes[0] == 0) {
            System.out.println("\n[Separate Chaining] Value does not exist.");
        } else {
            System.out.print("\n[Separate Chaining] Value: " + w + ", Index: ");
            for (int i = 0; i < indexes.length; i++) {
                if (indexes[i] == 0) {
                    break;
                } else {
                    System.out.print(indexes[i]);
                }

            }
            System.out.println("");
        }
    }

    // Enumerations: types of data structures
    public enum DataStructures {
        LinearProb, DoubleHash, SepChain
    }

    // Hash Function; returns hashcode value
    public int HashFunction(String w) {
        int hashValue = 0;
        for (int x = 0; x < w.length(); x++) {
            hashValue += w.charAt(x) * 31 ^ (w.length());
        }
        return hashValue;
    }

    // This method prints the hash table for open addressing; Linear Probing data structure
    public void printLinearTable() {
        System.out.println("\nHash Table - Linear Probing: ");
        for (int i = 0; i < LinearProbTable.length; i++) {
            if (LinearProbTable[i] != null) {
                if (i < 10) {
                    System.out.println(" " + i + " |" + LinearProbTable[i]);
                } else if (i >= 10 && i < 100) {

                    System.out.println(i + " |" + LinearProbTable[i]);

                } else {
                    System.out.println(i + "|" + LinearProbTable[i]);
                }
            } else {
                if (i < 10) {
                    System.out.println(" " + i + " |" + "");
                } else if (i >= 10 && i < 100) {

                    System.out.println(i + " |" + "");

                } else {
                    System.out.println(i + "|" + "");
                }
            }

        }
        System.out.println();
    }

    // This method prints the hash table for open addressing; Double hashing data structure
    public void printDoubleTable() {
        System.out.println("\nHash Table - Double Hashing: ");
        for (int i = 0; i < DoubleHashTable.length; i++) {
            if (DoubleHashTable[i] != null) {
                if (i < 10) {
                    System.out.println(" " + i + " |" + DoubleHashTable[i]);
                } else if (i >= 10 && i < 100) {

                    System.out.println(i + " |" + DoubleHashTable[i]);

                } else {
                    System.out.println(i + "|" + DoubleHashTable[i]);
                }
            } else {
                if (i < 10) {
                    System.out.println(" " + i + " |" + "");
                } else if (i >= 10 && i < 100) {

                    System.out.println(i + " |" + "");

                } else {
                    System.out.println(i + "|" + "");
                }
            }
        }
        System.out.println();
    }

    // This method prints the hash table for Separate Chaining data structure
    public void printSeparateTable() {
        System.out.println("\nHash Table - Separate Chaining: ");
        for (int i = 0; i < SCHashTable.length; i++) {
            if (SCHashTable[i] != null) {
                if (i < 10) {
                    System.out.println(" " + i + " |" + SCHashTable[i]);
                } else if (i >= 10 && i < 100) {

                    System.out.println(i + " |" + SCHashTable[i]);

                } else {
                    System.out.println(i + "|" + SCHashTable[i]);
                }
            } else {
                if (i < 10) {
                    System.out.println(" " + i + " |" + "");
                } else if (i >= 10 && i < 100) {

                    System.out.println(i + " |" + "");

                } else {
                    System.out.println(i + "|" + "");
                }
            }
        }
        System.out.println();
    }

    // Clears all element in all hash tables for linear probing 
    public void clearLinearTable() {
        for (int i = 0; i < LinearProbTable.length; i++) {
            LinearProbTable[i] = null;

        }
        System.out.println("\n***************************************************************\n");
        System.out.println("Linear Probing hash table successfully cleared.");
    }

    // Clears all element in all hash tables for double hashing
    public void clearDoubleTable() {
        for (int i = 0; i < DoubleHashTable.length; i++) {
            DoubleHashTable[i] = null;
        }
        System.out.println("Double Hashing hash table successfully cleared.");
    }

    // Clears all element in all hash tables for separate chaining
    public void clearSeparateTable() {
        for (int i = 0; i < SCHashTable.length; i++) {
            SCHashTable[i] = null;
        }
        System.out.println("Separate Chaining hash table successfully cleared.");
        System.out.println("\n***************************************************************\n");
    }

}
