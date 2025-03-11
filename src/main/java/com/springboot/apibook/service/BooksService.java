package com.springboot.apibook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.apibook.dao.BookRepository;
import com.springboot.apibook.entity.Books;

@Component
//WE CAN ALSO USE @Service.
public class BooksService {

	@Autowired
	private BookRepository bookRepository;
//	private static List<Books> list=new ArrayList<>();
//	 static{
//		 list.add(new Books(12,"Java","XYZ"));
//		 list.add(new Books(13,"Java New","PQR"));
//		 list.add(new Books(14,"Java Advanced","jkl"));
//	 } 
		 //get all books 
		 public  List<Books> getAllBooks(){
//			 return list;
			List<Books> list=(List<Books>) this.bookRepository.findAll();
			return list;
		 }
		// get single book by id
		  public Books getBooksById(int id) {
			  Books books=null;
//			 books= list.stream().filter(e->e.getId()==id).findFirst().get();
			  books = this.bookRepository.findById(id);
			 return books;
		  }
	   //add book
			 public Books addBooks(Books b) {
//				 list.add(b);
				 Books books = this.bookRepository.save(b);
				 return  books;
			 }
			 
		//delete one book
			 public void deleteBooks(int bid) {
//				list= list.stream().filter(e->e.getId()!=bid).collect(Collectors.toList()); 
                 this.bookRepository.deleteById(bid);			
			 }
			  
	   //Update the data 
			 public Books updateBooks(Books books,int Id ) 
			{
//				 list.stream().map(b->{
//				 if(b.getId()==Id)
//				 {
//					b.setName(books.getName()) ;
//					b.setAuthor(books.getAuthor());
//				 }
//				 return b;
//				 }).collect(Collectors.toList());
//				return books;
				 books.setId(Id);
				 return this.bookRepository.save(books);
}}




