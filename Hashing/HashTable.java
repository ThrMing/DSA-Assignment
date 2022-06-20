class HashTable
{
    int[] arr;
    int capacity;
    int count;
 
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
   
   public synchronized boolean contains(int ele) {
       if (ele == null) {
           throw new NullPointerException();
       }

       Entry<?,?> tab[] = table;
       for (int i = tab.length ; i-- > 0 ;) {
           for (Entry<?,?> e = tab[i] ; e != null ; e = e.next) {
               if (e.value.equals(ele)) {
                   return true;
               }
           }
       }
       return false;
   }
    /** function to insert **/
    public void insert(int ele)
    {
        arr[ele % capacity] = ele;
    }
 
    /** function to clear **/
    public void clear()
    {
        arr = new int[capacity];
    }
 
    /** function contains **/
    public boolean contains(int ele)
    {
        return arr[ele % capacity] == ele;
    }
 
    /** function to delete **/
    public void delete(int ele)
    {
        if (arr[ele % capacity] == ele)
            arr[ele % capacity] = 0;
        else
            System.out.println("\nError : Element not found\n");
        	System.out.println("Hashtable contains: " + ele);

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
