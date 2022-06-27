package HashingVer2;

import java.util.LinkedList;

public class Hashing {
    String[] DoubleHashTable;
    String[] LinearProbTable;
    LinkedList<String>[] SCHashTable;
    int arrSize = 0;
    
    // Constructor
    public Hashing(int n, DataStructures ds) {
        n = arrSize;
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

    public int getPrime() {
        for(int i = arrSize-1;i>=1;i--) {
            int f = 0;
            for(int j=2;j<=(int)Math.sqrt(i);j++) {
                if(i%j==0) {
                    f++;
                }
            }
            if(f==0) {
                return i;
            }
        }
        return 3;
    }

    public void insertLinearProb(String w) {
        int hashValue = HashFunction(w);
        int index = hashValue % arrSize;
        boolean notStored = true;
        while(notStored) {
            if(LinearProbTable[index] == null) {
                LinearProbTable[index] = w;
                notStored = false;
            }
            else {
                hashValue++;
            }
        }
    }

    public void insertDoubleHash(String w) {
        int hashValue = HashFunction(w);
        int constant = getPrime();
        int index = hashValue % arrSize;
        int stepSize = constant - (hashValue % constant); 
        boolean notStored = true;
        while(notStored) {
            if(DoubleHashTable[index] == null) {
                DoubleHashTable[index] = w;
                notStored = false;
            }
            else {
                index += stepSize;
                index %= arrSize;
            }
        }
    }
    
    // Enumerations: types of data structures
    public enum DataStructures {
        LinearProb, DoubleHash, SepChain
    }

    // Hash Function; returns hashcode value  
    public int HashFunction(String w) {
        int hashValue = 0;
        for (int x = 0; x<w.length(); x++) {
            hashValue += w.charAt(x)*31^(w.length());
        }
        return hashValue;
    }
}
