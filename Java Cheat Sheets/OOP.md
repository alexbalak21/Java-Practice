# Java OOP Cheat Sheet (Concepts, Rules & Examples)

---

# 1. What is OOP?
Object-Oriented Programming organizes code into objects that contain:
- Data (fields)
- Behavior (methods)

Java is a **pure OOP language** (except for primitives).

---

# 2. The 4 Pillars of OOP

---

# 2.1 Encapsulation
Hide internal data and expose only what is necessary.

## How?
- Make fields `private`
- Provide `public` getters/setters

## Example
```java
public class User {
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

---

# 2.2 Inheritance
A class can inherit fields and methods from another class.

## Syntax
```java
class Child extends Parent { }
```

## Example
```java
class Animal {
    void eat() { System.out.println("eating"); }
}

class Dog extends Animal {
    void bark() { System.out.println("barking"); }
}
```

---

# 2.3 Polymorphism
Same method name, different behavior.

## Two types:
- **Compile-time polymorphism** → method overloading
- **Runtime polymorphism** → method overriding

### Overloading example
```java
void print(int x) {}
void print(String s) {}
```

### Overriding example
```java
class A {
    void run() { System.out.println("A running"); }
}

class B extends A {
    @Override
    void run() { System.out.println("B running"); }
}
```

---

# 2.4 Abstraction
Expose only essential features; hide implementation details.

## Achieved with:
- Abstract classes
- Interfaces

---

# 3. Classes & Objects

## Class = blueprint  
## Object = instance

### Example
```java
class Car {
    String brand;
    void drive() { System.out.println("Driving"); }
}

Car c = new Car();
c.brand = "BMW";
c.drive();
```

---

# 4. Constructors

## Default constructor
```java
class A {
    A() { }
}
```

## Parameterized constructor
```java
class A {
    int x;
    A(int x) { this.x = x; }
}
```

## Constructor overloading
```java
A() {}
A(int x) {}
```

---

# 5. this & super

## this
Refers to the current object.

```java
this.x = x;
```

## super
Refers to the parent class.

```java
super.run();
```

---

# 6. Abstract Classes

## Rules
- Cannot be instantiated
- Can have abstract + non-abstract methods
- Can have fields, constructors

## Example
```java
abstract class Shape {
    abstract double area();
}
```

---

# 7. Interfaces

## Rules
- All methods are abstract by default (until Java 8)
- Supports multiple inheritance
- Can have default and static methods

## Example
```java
interface Flyable {
    void fly();
}
```

## Implementing
```java
class Bird implements Flyable {
    public void fly() { System.out.println("Flying"); }
}
```

---

# 8. Method Overloading vs Overriding

## Overloading
- Same name
- Different parameters
- Same class

## Overriding
- Same name
- Same parameters
- Child class replaces parent behavior

---

# 9. Access Modifiers

| Modifier   | Class | Package | Subclass | World |
|-----------|-------|---------|----------|--------|
| private   | ✔     | ✘       | ✘        | ✘      |
| default   | ✔     | ✔       | ✘        | ✘      |
| protected | ✔     | ✔       | ✔        | ✘      |
| public    | ✔     | ✔       | ✔        | ✔      |

---

# 10. Composition vs Inheritance

## Inheritance
"Is a" relationship  
```java
class Dog extends Animal {}
```

## Composition
"Has a" relationship  
```java
class Car {
    Engine engine = new Engine();
}
```

Composition is often better than inheritance.

---

# 11. Final Keyword

## final variable
Cannot be changed.

## final method
Cannot be overridden.

## final class
Cannot be extended.

```java
final class Utils {}
```

---

# 12. Static Keyword

## static field
Shared across all instances.

## static method
Belongs to the class, not the object.

```java
class MathUtils {
    static int add(int a, int b) { return a + b; }
}
```

---

# 13. Common OOP Patterns in Java

## Factory pattern
```java
class ShapeFactory {
    static Shape create(String type) {
        return switch(type) {
            case "circle" -> new Circle();
            case "square" -> new Square();
            default -> null;
        };
    }
}
```

## Singleton pattern
```java
class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() { return instance; }
}
```

---

# 14. Summary Table

| Concept | Meaning | Example |
|--------|---------|---------|
| Encapsulation | Hide data | private fields + getters |
| Inheritance | Reuse behavior | extends |
| Polymorphism | Many forms | override/overload |
| Abstraction | Hide complexity | abstract class, interface |
| Composition | Has-a | Car has Engine |
| Overriding | Replace parent method | @Override |
| Overloading | Same name, diff params | print(int), print(String) |

```
