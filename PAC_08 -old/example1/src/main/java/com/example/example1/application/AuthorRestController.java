package com.example.example1.application;

import javax.validation.Valid;

import com.example.example1.services.AuthorService;
import com.example.example1.domini.Author;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api")
//http://localhost:8086/api/authors
public class AuthorRestController {

	// En lloc d'utilitzar el @Autowired
	private AuthorService authorservice;

	public AuthorRestController(AuthorService authorservice) {
		this.authorservice = authorservice;
	}

	@GetMapping("/authors")
	public ResponseEntity<Iterable<Author>>getAllAuthors (){
		var headers = new HttpHeaders();
		headers.add("ResponseGet","getAllAuthors executed");
		headers.add("version","1.0 Api Rest Author Object");
		
		return
		ResponseEntity.accepted().headers(headers).body(authorservice.getAllAuthors());
		}
	
	
	
	@PostMapping(path = "/addauthor", consumes = "application/json")
	public ResponseEntity<Author> createAuthor(@RequestBody @Valid Author author) {
//		Author AuthorSaved = authorservice.addAuthorToArray(author);
		
		var headers = new HttpHeaders();
		headers.add("ResponseCreate", "createAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", "Author created");
		return ResponseEntity.accepted().headers(headers).body(authorservice.createAuthor(author));
	}


	//String id = UUID.randomUUID().toString();
	@DeleteMapping("/deleteauthor/{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable int id) {
		String deleteSentence;
//		Author deleteAuthor = null;
//
//		if (authorservice.findAuthorById(id) != -1) {
//			deleteSentence = "Author with ID: " + id + " was deleted from the list";
//			authorservice.deleteAuthorFromArray(id);
//
//		}
//
//		else {
//			deleteSentence = "Author with id: " + id + " does not exist";
//		}

		deleteSentence = authorservice.findAndDeleteAuthor(id);
		var headers = new HttpHeaders();
		headers.add("ResponseDeleted", "deleteAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", deleteSentence);
		return ResponseEntity.accepted().headers(headers).body(deleteSentence);

	}


	@PostMapping("/updateauthor/{id}")
    public ResponseEntity<Author> updateAuthor (@PathVariable int id, @RequestBody Author authorFromRest) {

//    Author authorToUpdate = null;
//
//    	int index = authorservice.findAuthorById(id);
//    	if (authorservice.findAuthorById(id) !=-1)
//
//    		{authorToUpdate = authorservice.getAuthorByIndex(index);
//    		updateSentence = "Author found\n";
//
//
//    		if (authorFromRest.getName() !=null) {
//    			updateSentence += "-Author name value updated: " + authorFromRest.getName() + " (0ld value: " + authorToUpdate.getName()+")\n";
//    			authorToUpdate.setName (authorFromRest.getName());}
//
//    		if (authorFromRest.getCountry() !=null) {
//        		updateSentence += "-Author country value updated: " + authorFromRest.getCountry() + " (Old value: " + authorToUpdate.getCountry()+")\n";
//        		authorToUpdate.setCountry(authorFromRest.getCountry());}
//
//    		if (authorFromRest.getDob() !=0) {
//        		updateSentence += "-Author DoB value updated: " + authorFromRest.getDob() + " (Old value: " + authorToUpdate.getDob()+")\n";
//        		authorToUpdate.setDob(authorFromRest.getDob());}
//
//    		if (authorFromRest.getQtyBooks() !=0) {
//        		updateSentence += "-Author qtyBooks value updated: " + authorFromRest.getQtyBooks() + " (Old value: " + authorToUpdate.getQtyBooks()+")\n";
//        		authorToUpdate.setQtyBooks(authorFromRest.getQtyBooks());}
//
//    		if (authorFromRest.getAlive() !=authorToUpdate.getAlive()&&authorFromRest.getAlive() !=null) {
//        		updateSentence += "-Author alive value updated: " + authorFromRest.getAlive() + " (Old value: " + authorToUpdate.getAlive()+")\n";
//        		authorToUpdate.setAlive(authorFromRest.getAlive());}
//
//    	//authorservice.replaceAuthor (index, authorToUpdate);
//
//
//    		}else {
//    	updateSentence = "Invalid pharamethers";
//    }
//		String updateSentence = authorservice.updateAuthor(id, authorFromRest);
    	var headers = new HttpHeaders();
		headers.add("ResponseUpdate", "updateAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
//		headers.add("Executed Output", updateSentence);
    return ResponseEntity.accepted().headers(headers).body(authorservice.updateAuthor(id, authorFromRest));
    	
    
	} 
}