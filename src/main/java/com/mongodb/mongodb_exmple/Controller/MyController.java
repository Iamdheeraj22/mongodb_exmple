package com.mongodb.mongodb_exmple.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.mongodb.mongodb_exmple.Model.Student;
import com.mongodb.mongodb_exmple.repo.MongoRepo;

@RestController
public class MyController {
    @Autowired
    private MongoRepo mongoRepo;
    @PostMapping("/addUser")
    public String addStudent(@RequestBody Student student){
       this.mongoRepo.save(student);
        System.out.print(student);
        return "User added successfully";
    }
 
    //Get the all user data
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> addStudent(){
        return ResponseEntity.ok(this.mongoRepo.findAll());
    }

    //Get the user info by the userId
    @GetMapping("/getUserById/{_id}/")
    public ResponseEntity<?> getUserById(@PathVariable("_id") int _id){
        Optional<Student> user = mongoRepo.findById(_id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Update the user info by user Id
    @PutMapping("/updateUserInfo/{_id}/")
    public String UpdateUserInfo(@RequestBody Student studentDetails,@PathVariable("_id") Integer _id){
         Optional<Student> stdInfo= mongoRepo.findById(_id);
         if(stdInfo.isPresent()){
            Student studentInfo=mongoRepo.findById(_id).orElseThrow();
            studentInfo.setId(studentDetails.getId());
            studentInfo.setName(studentDetails.getName());
            studentInfo.setCity(studentDetails.getCity());
            studentInfo.setCollege(studentDetails.getCollege());
             this.mongoRepo.save(studentInfo);
            return "User information update successfully";
         }else{
            return "User id not found";}
    }
    //Delete the user
    @DeleteMapping("/deleteById/{_id}/")
    public String deleteUserById(@PathVariable("_id") int _id){
        Optional<Student> user = mongoRepo.findById(_id);
        if (user.isPresent()) {
            this.mongoRepo.deleteById(_id);
            return "User deleted successfully..";
        } else {
            return "user id not found...";
        }
    }
}
