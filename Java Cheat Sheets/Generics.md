# Java Generics Cheat Sheet (Syntax, Rules & Examples)

---

# 1. What Are Generics?
Generics allow classes, interfaces, and methods to operate on **types** while keeping type safety.

They prevent:
- Casting everywhere
- Runtime `ClassCastException`
- Duplicate code for different types

---

# 2. Generic Type Parameters

## Common letters
- T → Type
- E → Element
- K → Key
- V → Value
- R → Result

## Example
```java
class Box<T> {
    private T value;
    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

Usage:
```java
Box<String> b = new Box<>();
b.set("Hello");
```

---

# 3. Generic Methods

## Syntax
```java
public <T> void print(T value) {
    System.out.println(value);
}
```

## Example
```java
<T> T identity(T x) { return x; }
```

---

# 4. Bounded Generics

## Upper bound: ? extends
Means: “any subtype of X”

```java
List<? extends Number> nums;
```

You can **read**, but cannot **add** (except null).

### Example
```java
double sum(List<? extends Number> list) {
    return list.stream().mapToDouble(Number::doubleValue).sum();
}
```

---

## Lower bound: ? super
Means: “any supertype of X”

```java
List<? super Integer> ints;
```

You can **add**, but reading returns `Object`.

### Example
```java
void addInts(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```

---

# 5. Wildcards

## Unbounded wildcard: ?
```java
List<?> items;
```

Used when you don’t care about the type.

### Example
```java
void printAll(List<?> list) {
    list.forEach(System.out::println);
}
```

---

# 6. Generic Interfaces

```java
interface Repository<T> {
    void save(T entity);
}
```

Implementation:
```java
class UserRepo implements Repository<User> {
    public void save(User u) {}
}
```

---

# 7. Multiple Type Parameters

```java
class Pair<K, V> {
    K key;
    V value;
}
```

Usage:
```java
Pair<String, Integer> p = new Pair<>();
```

---

# 8. Generic Constructors

```java
class Printer {
    <T> Printer(T value) {
        System.out.println(value);
    }
}
```

---

# 9. Type Erasure (Important!)

Java removes generic types at runtime.

Meaning:
- `List<String>` and `List<Integer>` look the same at runtime
- No `new T[]`
- No `instanceof List<String>`

Example:
```java
List<String> a = new ArrayList<>();
List<Integer> b = new ArrayList<>();
System.out.println(a.getClass() == b.getClass()); // true
```

---

# 10. Restrictions in Generics

## ❌ Cannot instantiate type parameter
```java
T obj = new T(); // illegal
```

## ❌ Cannot create generic arrays
```java
T[] arr = new T[10]; // illegal
```

## ❌ Cannot use primitives
```java
List<int> nums; // illegal
```

Use wrappers:
```java
List<Integer> nums;
```

---

# 11. PECS Rule (VERY IMPORTANT)

**Producer Extends, Consumer Super**

- Use `? extends T` when you **read** (producer)
- Use `? super T` when you **write** (consumer)

Example:
```java
List<? extends Number> producer; // can read
List<? super Integer> consumer;  // can write
```

---

# 12. Real-World Examples

## Sorting with Comparator<T>
```java
List<String> names = List.of("Alex", "Bob");
names.stream().sorted(Comparator.naturalOrder());
```

## Generic Response Wrapper
```java
class Response<T> {
    T data;
    boolean success;
}
```

## Generic Repository
```java
interface Repo<T> {
    T findById(int id);
}
```

---

# 13. Summary Table

| Concept | Meaning | Example |
|--------|---------|---------|
| T | Type | Box<T> |
| ? | Unknown type | List<?> |
| ? extends T | Upper bound | List<? extends Number> |
| ? super T | Lower bound | List<? super Integer> |
| <T> | Generic method | <T> T id(T x) |
| Type erasure | Generics removed at runtime | List<String> == List<Integer> |

