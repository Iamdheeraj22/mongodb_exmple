package com.mongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.Model.Student;

public interface MongoRepo extends MongoRepository<Student,Integer> {
}
