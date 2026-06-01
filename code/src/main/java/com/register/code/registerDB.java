package com.register.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/backend")
public class registerDB {
    @Autowired
    private Repository userRepository;

    @PostMapping("/send")
    public void toDB(@RequestBody DTO request){
    userEntity user = new userEntity();

    user.setName(request.getUsername());
    user.setPassword(request.getPassword());
    userRepository.save(user);
    }
}
