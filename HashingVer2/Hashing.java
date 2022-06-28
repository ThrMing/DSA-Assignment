package HashingVer2;

import java.util.LinkedList;

public class Hashing {
    String[] DoubleHashTable;
    String[] LinearProbTable;
    LinkedList<String>[] SCHashTable;
    int arrSize;
    int count = 0;

    // Constructor
    public Hashing() {

    }

    public Hashing(int n, DataStructures ds) {
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

    // Insertion for Linear Probing data structure
    public void insertLinearProb(String w) {
        int hashValue = HashFunction(w);
        int index = hashValue % arrSize;
        boolean notStored = true;
        while (notStored) {
            if (LinearProbTable[index] == null) {
                LinearProbTable[index] = w;
                notStored = false;
            } else {
                index++;
            }
        }
    }

    // Searching for Linear Probing data structure 
    public void searchLinearProb(String w) {
        int hashValue = HashFunction(w);
        int index = hashValue % arrSize;

        boolean notFound = true;
        while(notFound) {
            if (LinearProbTable[index] != null) {
                if (w.equals(LinearProbTable[index])) {
                    System.out.println("Word: " + w + ", Hash Value: " + hashValue + ", Index: " + index);
                    notFound = false;
                }
                else {
                    index++;
                }
            }
            else {
                System.out.println("Word does not exist.");
                break;
            }
        }
        return;
    }

    // Insertion for Double Hashing data structure
    public void insertDoubleHash(String w) {
        int hashValue = HashFunction(w);
        int constant = getPrime();
        int index = hashValue % arrSize;
        int stepSize = constant - (hashValue % constant);
        boolean notStored = true;
        while (notStored) {
            if (DoubleHashTable[index] == null) {
                DoubleHashTable[index] = w;
                notStored = false;
            } else {
                index += stepSize;
                index %= arrSize;
            }
        }
    }

    // Insertion for Separate Chaining data structure
    public void insertSepChain(String w) {
        int hashValue = HashFunction(w);
        int index = hashValue % arrSize;
        if (SCHashTable[index] == null) {
            SCHashTable[index] = new LinkedList<String>();
            SCHashTable[index].add(w);
        } else {
            SCHashTable[index].add(w);
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

    public void printLinearTable() {
        System.out.println("Hash Table{Linear}: ");
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

    public void printDoubleTable() {
        System.out.println("Hash Table{Double}: ");
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

    public void printSeparateTable() {
        System.out.println("Hash Table{Separate}: ");
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

    public void clearLinearTable() {
        for (int i = 0; i < LinearProbTable.length; i++) {
            LinearProbTable[i] = null;

        }
        System.out.println("Linear Table Clear Successfully");

    }

    public void clearDoubleTable() {
        for (int i = 0; i < DoubleHashTable.length; i++) {
            DoubleHashTable[i] = null;
        }
        System.out.println("Double Table Clear Successfully");

    }

    public void clearSeparateTable() {
        for (int i = 0; i < SCHashTable.length; i++) {
            SCHashTable[i] = null;
        }
        System.out.println("Separate Table Clear Successfully");

    }

    public boolean searchValue(String value) {
        for (String i : LinearProbTable) {
            if (value.equals(i)) {
                System.out.println(value + " Can be found");
            } else {
                System.out.println("1");
            }

        }
        return false;

    }
}
