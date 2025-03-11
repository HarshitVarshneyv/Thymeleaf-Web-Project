package com.springboot.apibook.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.apibook.entity.Books;
import com.springboot.apibook.service.BooksService;

@RestController
public class MainController {
	
	@Autowired
	private BooksService booksService;
	
	
	//Controller
	//@RequestMapping(path="/books",method=RequestMethod.GET)
	@GetMapping(path="/books")
	//@ResponseBody  //as it is string chala jaye server pe because handler me view ko return krte h
	public List<Books> getBooks() { 
		return this.booksService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Books getBooksById(@PathVariable("id") int id) {
		return booksService.getBooksById(id);
	}
	
	//Create book handler
	@PostMapping("/books")
	public Books addBooks(@RequestBody Books books) {
		Books b=this.booksService.addBooks(books);
		return b;
	}
	
	@DeleteMapping("/books/{Id}")
	public void deleteBooks(@PathVariable("Id") int Id) {
		this.booksService.deleteBooks(Id); 
	}
	
	@PutMapping("/books/{Id}")
	public Books updateBooks(@RequestBody Books books,@PathVariable("Id") int Id) {
		Books b=this.booksService.updateBooks(books,Id);
		return b;
		
	}
	
}














