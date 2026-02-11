import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);




//            java.util ->package

//            Collection frameworks

//        Java provides collection frameworks like SET, MAP, QUEUE, LIST -> Interfaces

//            LIST -> ArrayList, LinkedList, VEctor, STack
//            MAP -> HASHMAP
//            SET -> HashSet, LInkedHashset
//            QUEUE -> PRIORITY_QUEUE



//            List vs Set

//            List is an ordered Sequnce. It allows duplicate elements.
//            posiiton access to elenent is possible using index
//
//
//            SET -> unordered and it does not allow duplicates
//            position access is not possible


//            _______________________________________________



//            ARRAYLIST

            //dynamic array -> resiable arrray,fast random access but slow insertion and deletion
//            because weneed to move the the elments if we add new element in between
            List<String> list1 = new ArrayList<>();


            //methods -> add,indexOf, set() -> update indx val
            //get() -> to get value at index, remove() -> to remove value at index
//            contains() -> to check if value is present
            list1.add("Apple");
            list1.add("Banana");


            //Linkedlist - DDL -> fast insertion and deletion but slow random access

            List<String> list2 = new ArrayList<>();
            list2.add("Orange");
            list2.add("Grapes");



//________________________________________________


//    LInkedLIst - DDL

//      elements are not stored in contiguous memory.
//       Each node contains three parts: the data, a reference to the next node, and a reference to the previous node

            List<String> linkedList = new LinkedList<>();
            linkedList.add("Dog");

//            get method to get element at a particular idx
//            add first
//            add last
//            get
//            indexOf()
//            peek - to get first element without removing
//            poll - to get and remove first element

//peekfirst, pollforst, peeklast,polllast

//           ARRAYLIST vs LINKEDLIST
//           dyanamic array vs DDL
//            O(1) random access vs O(n) random access
//           memory is lower
//            insertion ad deltion in middle or anywhere is faster in LINKEDLIST


//            VECTOR
            List<String> vector = new Vector<>();
            vector.add("Red");
            vector.add("Blue");

//     Thread-safe: All methods are synchronized for safe multi-threaded access.

//When a Vector is created using the default constructor, it is initialized with a default capacity of 10. This means it can hold up to 10 elements before needing to grow in size. If the number of elements exceeds the current capacity, the Vector automatically increases its capacity.


            Vector: synchronized → thread-safe, but slower

            ArrayList: not synchronized → faster, not thread-safe







        }
    }
}