package com.rk.app.rest.Controller;

import com.rk.app.rest.Models.User;
import com.rk.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    // Display a welcome page
    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    // Retrieves saved users from database
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    // Saves new user to database
    @PostMapping(value="/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved!";
    }

    // Change information in database for already saved users
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "Updated!";
    }

    // Remove user from database
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with the id: " + id + "!";
    }
}
