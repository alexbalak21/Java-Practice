```md
# Spring Boot Cheat Sheet (Annotations, Structure, Config, Examples)

---

# 1. What Is Spring Boot?
Spring Boot is a framework that simplifies building Java applications by providing:
- Auto‑configuration
- Embedded servers (Tomcat, Jetty)
- Opinionated defaults
- Easy dependency management (starters)

---

# 2. Project Structure (Typical)

```
src/
 └── main/
      ├── java/
      │    └── com.example.app
      │          ├── controller/
      │          ├── service/
      │          ├── repository/
      │          ├── model/
      │          └── AppApplication.java
      └── resources/
           ├── application.properties (or .yml)
           ├── static/
           └── templates/
```

---

# 3. Main Application Class

```java
@SpringBootApplication
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
```

`@SpringBootApplication` =  
`@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`

---

# 4. Common Spring Boot Annotations

## Core
- @SpringBootApplication  
- @Component  
- @Service  
- @Repository  
- @Controller  
- @RestController  
- @Autowired  
- @Value  

## Web
- @GetMapping  
- @PostMapping  
- @PutMapping  
- @DeleteMapping  
- @RequestMapping  
- @RequestParam  
- @PathVariable  
- @RequestBody  
- @ResponseStatus  

## JPA
- @Entity  
- @Id  
- @GeneratedValue  
- @Column  
- @Table  
- @OneToMany  
- @ManyToOne  
- @JoinColumn  

---

# 5. Controllers (REST API)

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }
}
```

---

# 6. Services

```java
@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User create(User u) {
        return repo.save(u);
    }
}
```

---

# 7. Repositories (Spring Data JPA)

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
}
```

Spring Data auto‑implements:
- save()
- findAll()
- findById()
- delete()
- Custom queries by method name

---

# 8. Entities (JPA)

```java
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
}
```

---

# 9. application.properties / application.yml

## application.properties
```
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=root
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=update
```

## application.yml
```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/db
    username: root
    password: pass
  jpa:
    hibernate:
      ddl-auto: update
```

---

# 10. Validation

```java
@PostMapping
public User create(@Valid @RequestBody User user) {
    return service.create(user);
}
```

Entity:

```java
@NotBlank
@Email
private String email;
```

Add dependency:
```
spring-boot-starter-validation
```

---

# 11. Exception Handling

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handle(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
```

---

# 12. Lombok (Optional but recommended)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
```

Add dependency:
```
lombok
```

---

# 13. Spring Boot Starters (Most Useful)

- spring-boot-starter-web  
- spring-boot-starter-data-jpa  
- spring-boot-starter-validation  
- spring-boot-starter-security  
- spring-boot-starter-test  
- spring-boot-starter-thymeleaf  
- spring-boot-starter-actuator  

---

# 14. Running the App

## Maven
```
mvn spring-boot:run
```

## Jar
```
mvn clean package
java -jar target/app.jar
```

---

# 15. Summary Table

| Layer | Purpose | Example |
|-------|---------|---------|
| Controller | Handles HTTP requests | @RestController |
| Service | Business logic | @Service |
| Repository | DB access | JpaRepository |
| Entity | Data model | @Entity |
| Config | App settings | application.yml |

```
