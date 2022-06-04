package com.mongodb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.Model.Student;
import com.mongodb.repo.MongoRepo;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/student")
public class MyController {
    @Autowired
    private MongoRepo mongoRepo;
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        Student save=this.mongoRepo.save(student);
        System.out.print(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/getall")
    public String getStudent(){
        return "hello world";
    }
}
