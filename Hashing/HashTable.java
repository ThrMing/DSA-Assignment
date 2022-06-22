import java.util.Arrays;
import java.util.LinkedList;

public class HashTable<K, V>
{
	 private class ListNode {
	    ListNode next;
		public K key;
		public V value; 
	}
	
	private ListNode[] table;
	private K key;
	private V value;
	private int hash;
	private int capacity;
	private int[] arr;
	private int count;
	private ListNode list;
    	 

  public HashTable(K key, V value) {
    this.key = key;
    this.value = value;
    this.hash = key.hashCode();
  }
  
  public boolean equals(HashTable<K, V> other) {
	    if (hash != other.hash) return false;
	    return key.equals(other.key);
	  }

	  @Override
	  public String toString() {
	    return key + " => " + value;
	  }
	

    /** constructor **/
   public HashTable(int capacity)
    {
        this.capacity = nextPrime(capacity);
        arr = new int[this.capacity];
    }
    
   public synchronized int size() {
       return count;
   }
   
   public synchronized boolean isEmpty() {
       return count == 0;
   }
   
   public void insert(K key, V value) {
    int bucket = hash(key); 
    ListNode list = table[bucket]; 
    while (list != null) {
       if (list.key.equals(key))
          break;
       list = list.next; 
    }
   }
    
   public void contains(K key, V value) {
	int bucket = hash(key); 
    ListNode list = table[bucket];  
    while (list != null) {
       if (list.key.equals(key))
          return;
       list = list.next;  
    }
    return;  
 }

 public void remove(K key, V value) { 
	int bucket = hash(key); 
    list = table[bucket]; 
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

 public boolean containsKey(Object key) {
    int bucket = hash(key);  
    ListNode list = table[bucket]; 
    while (list != null) {
       if (list.key.equals(key))
          return true;
       list = list.next;
    }
    return false;
 }
 
 public void clear() {
	    Arrays.fill(table, null);
	    int size = 0;
	  }

 private int hash(Object key) {
    return (Math.abs(key.hashCode())) % table.length;
 }
 
    /** Function to generate next prime number >= n **/
    private static int nextPrime( int n )
    {
        if (n % 2 == 0)
            n++;
        for (; !isPrime(n); n += 2);
 
        return n;
    }
 
    /** Function to check if given number is prime **/
    private static boolean isPrime(int n)
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
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
