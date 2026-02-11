package List;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_Impl {


//            ARRAYLIST

    //dynamic array -> resiable arrray,fast random access but slow insertion and deletion
//            because weneed to move the the elments if we add new element in between
    List<String> list1 = new ArrayList<>();


//methods -> add,indexOf, set() -> update indx val
//get() -> to get value at index, remove() -> to remove value at index
//            contains() -> to check if value is present
            list1.add("Apple");
            list1.add("Banana");


//  Linkedlist - DDL -> fast insertion and deletion but slow random access

    List<String> list2 = new ArrayList<>();
            list2.add("Orange");
            list2.add("Grapes");



//  Array List is not synchronised and not thread safe but it is faster


//  WHhere as vector is thread safe, synchronized and slower.

}