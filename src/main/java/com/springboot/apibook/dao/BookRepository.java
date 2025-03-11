package com.springboot.apibook.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.apibook.entity.Books;

public interface BookRepository extends CrudRepository<Books,Integer>{

	public Books findById(int id);
}
