package com.pranav.spring.boot.backend.user;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Add other fields, getters, and setters

    // Constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Default constructor (required by JPA)
    public User() {
    }

    // Getters and setters
}
