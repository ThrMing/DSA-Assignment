package HashingVer2;

import java.util.LinkedList;

public class Hashing {
    String[] DoubleHashTable;
    String[] LinearProbTable;
    LinkedList<String>[] SCHashTable;

    public Hashing(int n, DataStructures ds) {
        switch(ds) {
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

    public enum DataStructures {
        LinearProb, DoubleHash, SepChain
    }


}
