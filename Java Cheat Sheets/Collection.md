# Java Collections CheatSheet (Methods, Attributes & Examples)

---

# 1. Arrays
Fixed-size, fastest access, low-level.

## Attributes
- Fixed length
- Stores primitives or objects
- Index-based access (O(1))

## Common operations
- arr.length
- Arrays.sort(arr)
- Arrays.toString(arr)

## Example
```java
int[] nums = {1, 2, 3};
System.out.println(nums[0]); // 1
```

---

# 2. Lists (Ordered, indexed, allow duplicates)

# 2.1 ArrayList
Dynamic array — most used list.

## Attributes
- Fast random access (O(1))
- Slow insert/remove in middle (O(n))
- Allows duplicates
- Resizable

## Common methods
- add(E e)
- add(int index, E e)
- get(int index)
- set(int index, E e)
- remove(int index)
- size()
- contains(Object o)
- sort(Comparator)

## Example
```java
List<String> list = new ArrayList<>();
list.add("apple");
list.add("banana");
System.out.println(list.get(0)); // apple
```

---

# 2.2 LinkedList
Doubly linked list — rarely needed today.

## Attributes
- Fast insert/remove at ends (O(1))
- Slow random access (O(n))
- Implements List + Queue

## Common methods
- addFirst(E e)
- addLast(E e)
- removeFirst()
- removeLast()
- getFirst()
- getLast()

## Example
```java
LinkedList<Integer> q = new LinkedList<>();
q.addFirst(10);
q.addLast(20);
```

---

# 3. Sets (No duplicates, no indexing)

# 3.1 HashSet
Fastest set.

## Attributes
- No duplicates
- No order
- O(1) add/remove/contains

## Methods
- add(E e)
- remove(Object o)
- contains(Object o)
- size()

## Example
```java
Set<String> s = new HashSet<>();
s.add("A");
s.add("A"); // ignored
```

---

# 3.2 LinkedHashSet
HashSet + remembers insertion order.

## Attributes
- Predictable iteration order
- Slightly slower than HashSet

## Example
```java
Set<String> s = new LinkedHashSet<>();
s.add("B");
s.add("A");
System.out.println(s); // [B, A]
```

---

# 3.3 TreeSet
Sorted set (Red-Black Tree).

## Attributes
- Sorted automatically
- No duplicates
- O(log n) operations

## Methods
- first()
- last()
- higher(E e)
- lower(E e)

## Example
```java
Set<Integer> t = new TreeSet<>();
t.add(5);
t.add(1);
t.add(3);
System.out.println(t); // [1, 3, 5]
```

---

# 4. Maps (Key → Value)

# 4.1 HashMap
Fastest map.

## Attributes
- No order
- Allows null keys/values
- O(1) average operations

## Methods
- put(K key, V value)
- get(Object key)
- remove(Object key)
- containsKey(Object key)
- keySet()
- values()
- entrySet()

## Example
```java
Map<String, Integer> m = new HashMap<>();
m.put("age", 30);
System.out.println(m.get("age")); // 30
```

---

# 4.2 LinkedHashMap
HashMap + predictable order.

## Attributes
- Keeps insertion order
- Used for LRU caches

## Example
```java
Map<String, Integer> m = new LinkedHashMap<>();
m.put("a", 1);
m.put("b", 2);
System.out.println(m); // {a=1, b=2}
```

---

# 4.3 TreeMap
Sorted map.

## Attributes
- Keys sorted automatically
- O(log n) operations

## Methods
- firstKey()
- lastKey()
- higherKey(K key)
- lowerKey(K key)

## Example
```java
Map<Integer, String> t = new TreeMap<>();
t.put(3, "C");
t.put(1, "A");
System.out.println(t); // {1=A, 3=C}
```

---

# 5. Queues & Deques

# 5.1 ArrayDeque
Best queue & best stack.

## Attributes
- Faster than LinkedList
- No capacity limit
- No null elements allowed

## Methods
- addFirst(E e)
- addLast(E e)
- pollFirst()
- pollLast()
- peekFirst()
- peekLast()

## Example
```java
Deque<Integer> dq = new ArrayDeque<>();
dq.addLast(10);
dq.addLast(20);
System.out.println(dq.pollFirst()); // 10
```

---

# 5.2 PriorityQueue
Min-heap by default.

## Attributes
- Retrieves smallest element first
- O(log n) insert/remove

## Methods
- offer(E e)
- poll()
- peek()

## Example
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(5);
pq.offer(1);
pq.offer(3);
System.out.println(pq.poll()); // 1
```

---

# 6. Utility Classes

## Collections
- Collections.sort(list)
- Collections.reverse(list)
- Collections.shuffle(list)
- Collections.max(list)
- Collections.min(list)

## Arrays
- Arrays.sort(arr)
- Arrays.toString(arr)
- Arrays.copyOf(arr, newSize)

## Stream API
- list.stream().filter(...)
- map(...)
- reduce(...)
- collect(...)

---

# Summary Table

| Category | Implementations | Notes |
|---------|-----------------|-------|
| Arrays | int[], String[] | Fast, fixed size |
| Lists | ArrayList, LinkedList | Ordered, duplicates allowed |
| Sets | HashSet, LinkedHashSet, TreeSet | No duplicates |
| Maps | HashMap, LinkedHashMap, TreeMap | Key/value pairs |
| Queues | ArrayDeque, PriorityQueue | FIFO, heaps |
| Utilities | Collections, Arrays, Streams | Helpers |

