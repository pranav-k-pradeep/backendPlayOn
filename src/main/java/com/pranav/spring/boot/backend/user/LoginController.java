package com.pranav.spring.boot.backend.user;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        String userType = loginRequest.getUserType();

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            if (userType.equals("player")) {
                return ResponseEntity.ok("Player login successful");
            } else if (userType.equals("turf-owner")) {
                return ResponseEntity.ok("Turf Owner login successful");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
