# Java Collections CheatSheet

## 1. Arrays
- Fixed size
- Fast access (O(1))
- Syntax: `int[] arr = {1,2,3};`
- Use when size is known and performance matters

---

## 2. Lists (ordered, indexed, allow duplicates)

### Main implementations:
### ArrayList
- Dynamic array
- Fast reads, slow inserts in middle
- 95% of real-world use cases

### LinkedList
- Doubly linked list
- Fast insert/remove at ends
- Rarely useful today

### Vector (legacy)
### Stack (legacy, replaced by Deque)

---

## 3. Sets (no duplicates, no indexing)

### HashSet
- Fastest (O(1) average)
- No order

### LinkedHashSet
- Keeps insertion order

### TreeSet
- Sorted set (O(log n))
- Uses Red-Black Tree

---

## 4. Maps (key/value pairs)

### HashMap
- Fastest (O(1) average)
- No order

### LinkedHashMap
- Predictable iteration order
- Great for LRU caches

### TreeMap
- Sorted keys (O(log n))

### Hashtable (legacy)

---

## 5. Queues & Deques

### ArrayDeque
- Best queue
- Best stack
- Replaces Stack and LinkedList

### PriorityQueue
- Min-heap
- Used for scheduling, Dijkstra, etc.

### LinkedList
- Also implements Queue

---

## 6. Utility Classes

### Collections
- Sorting, reversing, shuffling

### Arrays
- Array utilities

### Stream API
- Functional operations

### Iterator / Iterable
- Looping mechanisms

---

# The 8 Collections You Actually Need to Know

1. ArrayList  
2. LinkedList  
3. HashSet  
4. LinkedHashSet  
5. TreeSet  
6. HashMap  
7. LinkedHashMap  
8. TreeMap  

---

# Quick Summary Table

| Category | Implementations | Notes |
|---------|-----------------|-------|
| Arrays | int[], String[] | Fast, fixed size |
| Lists | ArrayList, LinkedList | Ordered, duplicates allowed |
| Sets | HashSet, LinkedHashSet, TreeSet | No duplicates |
| Maps | HashMap, LinkedHashMap, TreeMap | Key/value pairs |
| Queues | ArrayDeque, PriorityQueue | FIFO, heaps |
| Utilities | Collections, Arrays, Streams | Helpers |

