package com.example.example1.commandLine;

import com.example.example1.domini.Author;
import com.example.example1.interficies.AuthorRepository;
import com.github.javafaker.Faker;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCommandRun implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    AuthorRepository authorRepository;

	@Override
    public void run(String... args) throws Exception {

    authorRepository.save(new Author("William Shakespeare", "Unite Kigndoom", 1564, 48, false));
    authorRepository.save(new Author("Enric", "Moiá", 1997, 0, true));
    authorRepository.save(new Author("Joan Jones", "New York", 1982, 3, true));
    authorRepository.save(new Author("Teresa Smith", "Australia", 1976, 1, true));
        //name, country, dob, qtyBooks, alive)
     //   Author author1 = new Author("William Shakespeare", "Unite Kigndoom", 1564, 48, false);
     //   Author author2 = new Author("Enric", "Moiá", 1997, 0, true);
     //   Author author3 = new Author("Un altre autor més", "Algún lloc", 2000, 2, true);


 //mongosh "mongodb+srv://cluster0.dejvi.mongodb.net/myFirstDatabase" --apiVersion 1 --username Milaein
   
    List<Author> authors = authorRepository.findAll();
    logger.info("Data Authors query get" + authors);
    logger.info("Authors count:" + authorRepository.count());
    }



    public void createAuthor() {
		authorRepository.deleteAll();
		
		Faker faker = new Faker();
		
		for (int i = 1; i <51; i++) {
				String id;
				String name;
				Object country;
				int dob;
				int qtyBooks;
				Author.save(new Author (
										id= "000" + i , 
										name= faker.name().fullName(),
										country = faker.country().countryCode2(),
										dob= faker.number().numberBetween(1920, 2020),
										qtyBooks= faker.number().numberBetween(0, 999),
										true
										));
		
	}
    }
	}

