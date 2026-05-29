
# Java Exceptions Cheat Sheet (Types, Rules & Examples)

---

# 1. What Are Exceptions?
Exceptions represent **errors** or **unexpected events** during program execution.

Java uses exceptions to avoid crashing and to handle errors gracefully.

---

# 2. Exception Hierarchy

```
Throwable
 ├── Error (serious issues, not handled)
 └── Exception
       ├── RuntimeException (unchecked)
       └── Other Exceptions (checked)
```

---

# 3. Checked vs Unchecked Exceptions

## Checked Exceptions
- Must be handled with try/catch OR declared with `throws`
- Checked at compile time

Examples:
- IOException
- SQLException
- FileNotFoundException

```java
void read() throws IOException {}
```

## Unchecked Exceptions
- Subclasses of RuntimeException
- Not required to handle
- Usually programming errors

Examples:
- NullPointerException
- IndexOutOfBoundsException
- IllegalArgumentException

```java
int x = list.get(100); // unchecked
```

---

# 4. try / catch / finally

## Basic structure
```java
try {
    riskyCode();
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("Always runs");
}
```

---

# 5. Multiple catch Blocks

```java
try {
    readFile();
} catch (FileNotFoundException e) {
    // specific
} catch (IOException e) {
    // more general
}
```

---

# 6. Multi-catch (Java 7+)

```java
catch (IOException | SQLException e) {
    e.printStackTrace();
}
```

---

# 7. The throws Keyword

Used to declare that a method may throw an exception.

```java
void load() throws IOException {
    throw new IOException("Failed");
}
```

---

# 8. Throwing Exceptions Manually

```java
if (age < 0) {
    throw new IllegalArgumentException("Age cannot be negative");
}
```

---

# 9. Custom Exceptions

## Create your own exception
```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
```

## Use it
```java
void setAge(int age) throws InvalidAgeException {
    if (age < 0) throw new InvalidAgeException("Negative age");
}
```

---

# 10. try-with-resources (Auto-close)

Used for files, streams, sockets, etc.

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```

Automatically closes the resource.

---

# 11. Common Built-in Exceptions

| Exception | Type | Meaning |
|----------|------|---------|
| NullPointerException | unchecked | Using null reference |
| IndexOutOfBoundsException | unchecked | Invalid index |
| IllegalArgumentException | unchecked | Bad method argument |
| ArithmeticException | unchecked | Division by zero |
| IOException | checked | Input/output failure |
| FileNotFoundException | checked | File missing |
| SQLException | checked | Database error |

---

# 12. Best Practices

- Catch only what you can handle
- Never swallow exceptions silently
- Use specific exceptions, not generic `Exception`
- Prefer custom exceptions for domain logic
- Use try-with-resources for I/O
- Avoid using exceptions for normal flow

---

# 13. Example: Clean Exception Handling

```java
public User loadUser(String path) {
    try {
        return readUserFromFile(path);
    } catch (IOException e) {
        throw new RuntimeException("Failed to load user", e);
    }
}
```

---

# 14. Summary Table

| Concept | Meaning | Example |
|--------|---------|---------|
| try/catch | Handle errors | try { } catch { } |
| finally | Always runs | close resources |
| throws | Declares exception | void f() throws X |
| throw | Manually throw | throw new X() |
| Checked | Must handle | IOException |
| Unchecked | Optional | NullPointerException |
| Custom exception | Your own type | class MyEx extends Exception |

