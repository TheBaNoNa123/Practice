package com.Finance.Tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/backend")
public class Controller {

    @Autowired
    Repository userRepository;

    @PostMapping("/post")
    public void addData(@RequestBody List<DTO> dtoList){

        for(DTO dto: dtoList) {
            Entity user;
            user = new Entity();

            Optional<Entity> duplicateRow = userRepository.findByCategoryAndAmountAndDate(dto.getCategory(), dto.getAmount(), dto.getDate());


            if(duplicateRow.isPresent()){
                System.out.println("Already in database");
            }
            else{
               user.setDate(dto.getDate());
               user.setAmount(dto.getAmount());
               user.setCategory(dto.getCategory());
               userRepository.save(user);
            }

        }
    }
    @GetMapping("/get")
    public List<Entity> getData(){
        return userRepository.findAll();
    }

}
