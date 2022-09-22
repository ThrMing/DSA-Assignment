# This file contains instructions on how to run the Binary Search Tree and Hashing demo codes bundled in this code package as part of the CSC2103 Coursework.

### Before running any program, unzip all Java files and either open the containing folder of the unzipped Java files in an IDE or compile and run it in a terminal.

### Important Note(s):
- The program **only accepts integer values as input**. Any other inputs such as characters (alphabets) and special characters (punctuations etc.) are not supported and will return errors.
- When running the programs in an IDE, the IDE may display code errors due to the use of our own classes implemented as packages. However, the program can still be compiled and executed without errors.

## Both programs display clear instructions, guide and error messages for an easy experience in using the programs.

## =================================================

# Binary Search Tree program:
- To use the program, compile the folder named **BST** and run or execute the file **BSTtest.java**

#### Follow the steps below to use the program:
1. At the main menu, select a function by entering the integer of one of the displayed functions.
2. Entering "1" will invoke the main feature of the program, bringing the user to a submenu displaying the functions of data insertion, deletion, search and exit to main menu.
	- Selecting insert, delete and search will guide the user on the appropriate steps to complete the action:
		- Enter "1" to insert values into the binary search tree.
		- Enter "2" and a value to delete the specified value from the binary search tree.
		- Enter "3" and a value to search for the value in the binary search tree.
	- Entering "4" will bring the user back to the main menu.
3. To display the tree in preorder traversal, enter "2".
4. To display the tree in inorder traversal, enter "3".
5. To display the tree in postorder traversal, enter "4".
6. To display the full tree, enter "5".
7. To exit the program, enter "6".

## =================================================

# Hashing program:
- To use the program, compile the folder named **HashingProgram** and run or execute the file **HashingTest.java**

#### Follow the steps below to use the program:
1. Enter the size of the hash table that will be used to store data.
2. At the main menu, select a function by entering the integer of one of the displayed functions.
3. Entering "1" will allow the user to input values into the hash tables.
4. Entering "2" will allow the user to search for the input value in the hash tables.
5. Entering "3" will delete all values in all hash tables.
6. Entering "4" will bring the user to the submenu to select which hash table to view:
	- Enter "1" to display the hash table of linear probing when collision occurs
	- Enter "2" to display the hash table of double hashing when collision occurs
	- Enter "3" to display the hash table of separate chaining when collision occurs
7. To exit the program, enter "5".

- Functions 1-3 will display the results of the function on each hash table managed by Linear Probing, Double Hashing and Separate Chaining solutions for collision.
