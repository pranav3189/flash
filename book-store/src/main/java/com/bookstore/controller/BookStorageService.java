package com.bookstore.controller;

import java.util.Date;
import java.util.List;

import com.bookstore.controller.BookSearchDto;

public interface BookStorageService {

	public Book saveBookDetail(Book book);
	public List<Book> getAllBook();
	public void deleteBookById(Long id);
	public Book findById(Long id);
	public List<Book> findBycreatedDate(Date fromdate,Date todate);
	public List<Book> findByPriceNumberAuthor(BookSearchDto bsdt);
	
}
