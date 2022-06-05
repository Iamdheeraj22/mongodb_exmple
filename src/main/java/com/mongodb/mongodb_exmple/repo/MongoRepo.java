package com.mongodb.mongodb_exmple.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.mongodb_exmple.Model.Student;

public interface MongoRepo extends MongoRepository<Student,Integer> {
}
