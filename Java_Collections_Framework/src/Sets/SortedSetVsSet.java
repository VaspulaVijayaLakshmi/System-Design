package Sets;

//Set

//No duplicates
//No ordering guarantee
//Fast lookups


//Common implementations:

//HashSet → no order
//LinkedHashSet → insertion order

//Example:
//Set<Integer> set = new HashSet<>();



//SortedSet - INTERFCACE

//No duplicates
//Elements are always sorted

//Sorting based on:
//Comparable or Comparator

//Main implementation:
//TreeSet

//Example:
//SortedSet<Integer> s = new TreeSet<>();




//SORTED SETS USES RED_BLACK TREES

//What is a Red–Black Tree?

//A self-balancing Binary Search Tree that guarantees O(log n) time for:

//search
//insert
//delete


//Java uses it in:
//TreeMap
// TreeSet



//Why not perfectly balanced?
//
//Perfect balance is expensive
//Red–Black Trees allow slight imbalance






//Red–Black Tree rules
//
//Every node is red or black
//Root is always black
//No two red nodes are adjacent
//        (red node cannot have red parent or child)
//
//Every path from a node to NULL has same number of black nodes
//NULL (leaf) nodes are considered black


//Insert (high level)
//
//Insert like a BST
//Color new node red
//
//
//Fix violations using:
//
//Recoloring
//Rotations (LL, LR, RL, RR)
