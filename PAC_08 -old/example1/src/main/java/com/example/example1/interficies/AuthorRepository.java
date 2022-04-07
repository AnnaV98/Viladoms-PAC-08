package com.example.example1.interficies;

import com.example.example1.domini.Author;

import java.util.List;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface AuthorRepository extends MongoRepository <Author, Integer>{

    @Query("{fullname: ?0 }")
    List<Author> findItemByName(String name);


	
	
}