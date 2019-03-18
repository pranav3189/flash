package com.bookstore.controller;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface bookRepository extends JpaRepository<Book, Long>,JpaSpecificationExecutor<Book> {


	List<Book> findAll();
	Book findById(Long id);
	@Query("SELECT t FROM Book t where t.createdDate>= :gpu AND t.createdDate<= :apd")
	List<Book> findByCreatedDateBeetween(@Param("gpu") Date fromDate ,@Param("apd")Date toDate);
	
	

}
