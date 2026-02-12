
ELEVATOR SYSTEM


Direction 
Elevator Type


Multiple elevators
multiple floors

Users can:

Call elevator (UP/DOWN)
Select destination floor inside elevator


Design Patterns:

Strategy Pattern → Scheduling algorithm
State Pattern → Elevator movement states
Observer Pattern → Floor button events
Sing leton → ElevatorController



_______


TreeSet is a Set implementation backed by a Red-Black Tree (self-balancing BST).

It:

Stores unique elements
Keeps elements sorted
Provides log(n) time for add, remove, search



Why We Used TreeSet in Elevator?

In elevator:

TreeSet<Integer> upStops = new TreeSet<>();
TreeSet<Integer> downStops = new TreeSet<>(Collections.reverseOrder());


Why?

Need sorted stops
Need efficient next floor
pollFirst() gives next stop in O(log n)

For UP:
Smallest higher floor first

For DOWN:
Largest lower floor first


Perfect use case.