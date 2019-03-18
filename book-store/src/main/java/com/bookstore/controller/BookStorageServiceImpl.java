package com.bookstore.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class BookStorageServiceImpl implements BookStorageService {

	private final BookListSpecification bookListSpecification;
	
	
	
	@Autowired
	bookRepository bookRepository;
	
	

	public BookStorageServiceImpl(BookListSpecification bookListSpecification) {
		super();
		this.bookListSpecification = bookListSpecification;
	}


	@Override
	public Book saveBookDetail(Book book) {
		Book savebook=bookRepository.save(book);
		return savebook;
	}


	@Override
	public List<Book> getAllBook() {
		List<Book> bookList=bookRepository.findAll();
		return bookList;
	}


	@Override
	public void deleteBookById(Long id) {
		Book b=new Book();
		b.setId(id);
		bookRepository.delete(b);
		
	}


	@Override
	public Book findById(Long id) {
	Book book=	bookRepository.findById(id);
		return book;
	}
	
	@Override
	public List<Book> findBycreatedDate(Date fromdate,Date toDate){
		List<Book> bookList=bookRepository.findByCreatedDateBeetween(fromdate,toDate);
	return bookList;
	}
	
	
	@Override
	public List<Book> findByPriceNumberAuthor(BookSearchDto bsdt){
		List<Book> bookList=bookRepository.findAll(bookListSpecification.getFilter(bsdt));
	       return bookList;
	}
	
	
	
	
	
	

}
