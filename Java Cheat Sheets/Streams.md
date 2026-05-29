# Java Streams Cheat Sheet (Methods, Patterns & Examples)

---

# 1. What is a Stream?
A Stream is a pipeline for processing data in a functional style.

## Key attributes
- Does NOT store data
- Does NOT modify the original collection
- Supports chaining
- Lazy evaluation
- Can be parallel

---

# 2. Creating Streams

## From a collection
```java
list.stream()
```

## From an array
```java
Arrays.stream(arr)
```

## From values
```java
Stream.of(1, 2, 3)
```

## Infinite streams
```java
Stream.generate(Math::random)
Stream.iterate(0, n -> n + 1)
```

---

# 3. Intermediate Operations (return a Stream)

## filter()
```java
list.stream()
    .filter(x -> x > 10)
```

## map()
```java
list.stream()
    .map(String::toUpperCase)
```

## flatMap()
```java
list.stream()
    .flatMap(List::stream)
```

## sorted()
```java
list.stream()
    .sorted()
```

## distinct()
```java
list.stream()
    .distinct()
```

## limit() / skip()
```java
list.stream().limit(5)
list.stream().skip(3)
```

---

# 4. Terminal Operations (end the stream)

## forEach()
```java
list.stream().forEach(System.out::println);
```

## collect()
```java
List<String> result = list.stream()
    .filter(s -> s.startsWith("A"))
    .collect(Collectors.toList());
```

## reduce()
```java
int sum = list.stream()
    .reduce(0, Integer::sum);
```

## count()
```java
long c = list.stream().count();
```

## anyMatch / allMatch / noneMatch
```java
list.stream().anyMatch(x -> x > 10);
```

## findFirst / findAny
```java
list.stream().findFirst();
```

---

# 5. Collectors

## toList()
```java
.collect(Collectors.toList())
```

## toSet()
```java
.collect(Collectors.toSet())
```

## joining()
```java
String s = list.stream()
    .collect(Collectors.joining(", "));
```

## groupingBy()
```java
Map<String, List<String>> groups =
    list.stream().collect(Collectors.groupingBy(String::length));
```

## partitioningBy()
```java
Map<Boolean, List<Integer>> parts =
    nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
```

---

# 6. Common Patterns

## 1. Filter + Map
```java
list.stream()
    .filter(x -> x > 10)
    .map(x -> x * 2)
    .toList();
```

## 2. Find max/min
```java
list.stream().max(Integer::compareTo);
list.stream().min(Integer::compareTo);
```

## 3. Sum of integers
```java
int sum = list.stream().mapToInt(Integer::intValue).sum();
```

## 4. Convert list of objects to list of fields
```java
users.stream().map(User::getName).toList();
```

## 5. Remove duplicates
```java
list.stream().distinct().toList();
```

---

# 7. Parallel Streams

## Create a parallel stream
```java
list.parallelStream()
```

## Example
```java
list.parallelStream()
    .map(x -> x * 2)
    .toList();
```

---

# 8. Stream Rules to Remember
- Streams can be used **once**
- Intermediate ops are **lazy**
- Terminal ops **consume** the stream
- Avoid parallel streams for small data
- Avoid modifying external state inside streams

```
