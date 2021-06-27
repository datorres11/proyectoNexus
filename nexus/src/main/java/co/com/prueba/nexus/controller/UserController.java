package co.com.prueba.nexus.controller;

import co.com.prueba.nexus.dto.UserDto;
import co.com.prueba.nexus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        try{
            userService.createUser(userDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> deletePosition(@PathVariable String userName){
        try{
            userService.deleteUser(userName);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.CONFLICT);
        }
    }
}
