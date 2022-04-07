package com.example.example1.services;

import com.example.example1.domini.Author;

import com.example.example1.interficies.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthorService {

    //    static List<Author> authors = new ArrayList<Author>();
    @Autowired
    AuthorRepository authorRepository;

    Logger logger = LoggerFactory.getLogger(AuthorService.class);


    public Iterable<Author> getAllAuthors() {

        return authorRepository.findAll();
    }


    public Author createAuthor(Author author) {

        authorRepository.save(author);

        return author;

    }

    public String findAndDeleteAuthor(int id) {

        Optional<Author> author = authorRepository.findById(id);

        String message = "";

        if (author.isPresent()) {

            authorRepository.delete(author.get());
            logger.info("Author with id {} was deleted", id);
            message += "Author deleted";

        } else {
            logger.info("Author with id {} is not found", id);
            message += "Author not found";
        }
        return message;

    }


    public void deleteAuthorById(int id) {

        authorRepository.deleteById(id);
    }


    public Author updateAuthor(int id, Author newAuthor) {

        Optional<Author> oldAuthor = authorRepository.findById(id);
        String message = "";

        if (oldAuthor.isPresent()) {

            //La id no la cambiem
            oldAuthor.get().setAlive(newAuthor.getAlive());
            oldAuthor.get().setQtyBooks(newAuthor.getQtyBooks());
            oldAuthor.get().setCountry(newAuthor.getCountry());
            oldAuthor.get().setDob(newAuthor.getDob());
            oldAuthor.get().setName(newAuthor.getName());
            oldAuthor.get().setQtyBooks(newAuthor.getQtyBooks());

            authorRepository.save(oldAuthor.get());

            message += "Author successfully updated";
            logger.info("Author with id {} was successfully updated", id);
            return oldAuthor.get();
        } else {
            message += "Author not found";
            logger.info("Author with id {} was not found", id);
        }


        return null;

    }

    public long count(){
        return authorRepository.count();
    }

    public boolean existsById(int id){
        return authorRepository.existsById(id);
    }


}




/*    public AuthorService() {
        if (authors.isEmpty())
            generateAuthors();
    }

    private void generateAuthors() {
        //name, country, dob, qtyBooks, alive)
        Author author1 = new Author(14022022, "William Shakespeare", "Unite Kigndoom", 1564, 48, false);
        Author author2 = new Author(16022022, "Enric", "Moiá", 1997, 0, true);
        Author author3 = new Author(17022022, "Un altre autor més", "Algún lloc", 2000, 2, true);

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
    }


    public List<Author> queryAuthor() {
        return authors;
    }

    public Author addAuthorToArray(Author author) {
        authors.add(author);
        return author;
    }

    //Els equals sol funcionen amb variables tipus String
    public int findAuthorById(int id) {
        int index = -1;

        for (Author authorTemp : authors) {
            if (authorTemp.getId() == id) {
                index = authors.indexOf(authorTemp);
                break;
            }
        }
        return index;
    }

    public void deleteAuthorFromArray(int id) {
        int index = findAuthorById(id);
        authors.remove(index);
    }
    
    public Author getAuthorByIndex (int index) {
    
    	return authors.get(index);
    }

	public Author replaceAuthor(int index, Author authorToUpdate) {
		authors.set(index, authorToUpdate);
		return authorToUpdate;
	}

*/







