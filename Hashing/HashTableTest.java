import java.util.Scanner;

/** Class HashTableTest **/
public class HashTableTest
{
    @SuppressWarnings("unchecked")
	public static void main(String[] args)
    {    
        Scanner scan = new Scanner(System.in);
        HashTable table = new HashTable(64);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        String key, value;
        char ch;
        /**  Perform HashTable operations  **/
        do    
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert(K,V) ");
            System.out.println("2. get(K) ");
            System.out.println("3. contain(K) ");  
            System.out.println("4. remove(K) ");     
            System.out.println("5. clear");  
            System.out.print("Enter your command:  ");
 
			switch (TextIO.getlnInt())
            {
            case 1 : 
                System.out.println("\n   Key = ");
                key = TextIO.getln();
                System.out.print("   Value = ");
                value = TextIO.getln();
                table.insert(key,value);
                break;                          
            case 2 :                 
                System.out.println("\n   Key = ");
                key = TextIO.getln();
                System.out.println("   Value is " + table.get(key));
                break;                        
            case 3 : 
                System.out.println("\n   Key = ");
                key = TextIO.getln();
                System.out.println("   containsKey(" + key + ") is " 
                                             + table.containsKey(key));
                break;    
            case 4 :
            	System.out.print("\n   Key = ");
                key = TextIO.getln();
                table.remove(key);
                break; 
            case 5 : 
            	table.clear();
                System.out.println("Hash Table Cleared\n");
                break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
			
            /** Display hash table **/
			table.printTable();  
			
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
    }
}


