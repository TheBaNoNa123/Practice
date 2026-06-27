package com.register.code;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/backend")
public class registerDB {
    @Autowired
    private Repository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid DTO request){
        userEntity user = new userEntity();
        String hashedPassword = encoder.encode(request.getPassword());
        user.setName(request.getUsername());
        user.setPassword(hashedPassword);

        if(userRepository.existsByName(request.getUsername())){
            System.out.println("Duplicate username detected");
            return ResponseEntity.ok("Username already found. Please create a unique name.");
        }

        userRepository.save(user);
        return ResponseEntity.ok("Register successful.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody DTO request){
        //Optional is a container that may or may not hold a value
        //May have userEntity object depending on whether username is in database or not
        Optional<userEntity> userOptional = userRepository.findByName(request.getUsername());

        if(userOptional.isPresent()){
            //Declare user as reference to userEntity object
            userEntity user = userOptional.get();
            //Take userEntity object out of the optional and store it in user,
            //Now user can access the data in the userEntity object
            if(encoder.matches(request.getPassword(), user.getPassword())){
                System.out.println("Login successful");
                System.out.println("User ID: " + user.getId());
                return ResponseEntity.ok("Login successful.");
            }
            else{
                System.out.println("Invalid Password");
                return ResponseEntity.ok("Invalid password.");
            }
        }
        System.out.println("Username not found");
        return ResponseEntity.ok("Username cannot be found.");


    }

}

