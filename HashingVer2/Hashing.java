package HashingVer2;

import java.util.LinkedList;

public class Hashing {
    String[] HashTable;
    LinkedList<String>[] SCHashTable;

    public Hashing(int n, DataStructures ds, String word) {
        switch(ds) {
            case LinearProb:
                setLinearProb(n, word);
                break;
            case DoubleHash:
                setDoubleHash(n, word);
                break;
            case SepChain:
                setSepChain(n, word);
                break;
        }
    }

    public enum DataStructures {
        LinearProb, DoubleHash, SepChain
    }

    private void setLinearProb(int n,String w) {
        HashTable = new String[n]; 

    }

    private void setDoubleHash(int n,String w) {
        HashTable = new String[n]; 

    }

    private void setSepChain(int n,String w) {
        SCHashTable = new LinkedList[n]; 

    }


}
