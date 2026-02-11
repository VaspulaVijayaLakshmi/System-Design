package List;

public class AbstarctListImpl {

//    AbstractList is a skeletal implementation of the List interface.

//    public abstract class AbstractList<E>
//            extends AbstractCollection<E>
//            implements List<E>

//    It provides default implementations for most List methods so concrete classes
//    don’t have to implement everything.

//    What does AbstractList already give you?
//
//    Out of the box:
//    add(E e)
//    indexOf()
//    lastIndexOf()
//    iterator()
//    listIterator()
//    equals()
//    hashCode()


//    Methods you MUST implement
//
//    At minimum:
//
//    E get(int index);
//    int size();
//
//
//    If the list is modifiable, also override:
//
//    E set(int index, E element);
//    void add(int index, E element);
//    E remove(int index);
//
//
//    If you don’t override these → UnsupportedOperationException.



//    WHen I take array LIST class it has already implnetation right then why do
//        i need abstacrt list


//    As a user of Java collections
//
//    You’re right:
//
//    List<Integer> list = new ArrayList<>();
//
//
//✅ You do NOT need AbstractList
//    ArrayList already has a full implementation.
//
//    So for application code → you never need AbstractList
//

//    As a library / framework designer
//
//    This is where AbstractList matters.
//
//    Imagine you want to create your own List:
//
//    class MyReadOnlyList extends AbstractList<Integer> {
//        public Integer get(int index) { ... }
//        public int size() { ... }
//    }
//
//
//    Without AbstractList:
//
//    You must implement 20+ methods from List
//
//    High chance of bugs
//
//    Lots of duplicated code

}
