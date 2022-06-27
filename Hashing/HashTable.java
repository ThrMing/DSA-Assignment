package Hashing;
import java.util.Arrays;
import java.util.LinkedList;

public class HashTable
{
	int size = 64;
	HashTable hashTable[] = new HashTable[size];

	 private class ListNode {
	    ListNode next;
	    String key;
        String value;
	}
	
	private ListNode[] table;
	private int hash;
	private int capacity;
	private int[] arr;
	private int count;
	private ListNode temp;
	private String key;
	private String value;
    	 

  public HashTable() {
	  table = new ListNode[64];
  }
  
  public HashTable(int initialSize) {
      // Create a hash table with a specified initial size.
      // Precondition: initalSize > 0.
    table = new ListNode[initialSize];
 }
  
  public boolean equals(HashTable other) {
	    if (hash != other.hash) return false;
	    return key.equals(other.key);
	  }

  @Override
  public String toString() {
      return "[" + key + ", " + value + "]";
  }

   public synchronized int size() {
       return count;
   }
   
   public synchronized boolean isEmpty() {
       return count == 0;
   }
   
   public void insert(String key, String value) {
	HashTable<String, String> table = new HashTable<>(key, value);
    int bucket = getHash(key); 
    ListNode list = table[bucket]; 
    if(table[hash] == null) {
    	table[hash] = hashTable;
    	return;
    }
    HashTable<String,String> temp = table[hash];
        while(temp.next != null) {
        	 if(temp.key.equalsIgnoreCase(key)){
                 temp.value = value;
                 return;
             }
             temp = temp.next;
         }
         temp.next = table;
     }

   public String get(String key) {
	   int bucket = getHash(key);
	   ListNode list = table[bucket]; 
	   if(list != null) {
		   HashTable.ListNode temp = table[hash];
           while (!temp.key.equals(key)
        		   && temp.next != null) {
        	   temp = temp.next; 
       }
           return temp.value;
   }
	   return null;
}

           
private int getHash(String key) {
    return key.hashCode() % initialSize;
}

 public void remove(String key) { 
	int bucket = getHash(key); 
	ListNode list = table[bucket]; 
    if (table[bucket] == null) {
       return; 
    }
    if (table[bucket].key.equals(key)) {
       table[bucket] = table[bucket].next;
       count--; 
       return;
    }
     
    ListNode prev = table[bucket];  
    ListNode curr = prev.next;  
    while (curr != null && ! curr.key.equals(key)) {
       curr = curr.next;
       prev = curr;
    }
     
    if (curr != null) {
       prev.next = curr.next;
       count--;  // Record new number of items in the table.
    }
 }

 public boolean containsKey(String key) {
		int bucket = getHash(key); 
	    ListNode list = table[bucket];  
	    while(list != null) {
	        if (temp.key.equals(key))
	        	return true;
	        temp = temp.next;
	    }
	    return false;
	}

 public void clear() {
	    Arrays.fill(table, null);
	    int size = 0;
	  }

 private int hash(String key, String value) {
    return (Math.abs(key.hashCode())) % table.length;
 }
  
     
 
    /** function to print hash table **/
    public void printTable()
    {
        System.out.print("\nHash Table = ");
        for (int i = 0; i < capacity; i++)
            System.out.print(arr[i] +" ");
        System.out.println();
    }
}
