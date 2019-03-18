package com.bookstore.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.model.UploadFileResponse;


@RestController
@RequestMapping({"/api"})
public class BookStoreController {
	
	 @Autowired
	    private FileStorageService fileStorageService;
	 @Autowired
	    private BookStorageService bookStorageService;
	 
	 @PostMapping("/uploadBook")
	    public UploadFileResponse uploadBook(@ModelAttribute Book book,@RequestParam("file") MultipartFile file) {
		 UploadFileResponse ufr=null;
		 String fileName =null;
		 try{ 
		    fileName = fileStorageService.storeFile(file); 
	        book.setName(fileName);
	        book.setCreatedDate(new Date());
	         book=  bookStorageService.saveBookDetail(book);
	         ufr=new UploadFileResponse(fileName, "Success", "1");
	     }catch(Exception e){
	    	 ufr=new UploadFileResponse(fileName, "Fail", "2");
	     }
	     
	        return ufr;
	   
	 }
	 
	 
	 
	    @GetMapping("/getAllBook")
	    public List<Book> getAllBook() {
	       List<Book> bookList= bookStorageService.getAllBook();
	       return bookList;
	    }
	    
	    @DeleteMapping("/deleteBook/{id}")
	    public ResponseEntity<Response> deleteBook(@PathVariable long id) {
	    	bookStorageService.deleteBookById(id);
	    	 return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Book hs been deleted"), HttpStatus.OK);
	    }
	 
	    
	    @PutMapping("/bookChange/{id}")
	    public ResponseEntity<Response> updateStudent(@RequestBody Book book, @PathVariable long id) {

	    	Book bookOptional = bookStorageService.findById(id);

	    	if (bookOptional==null)
	    		return ResponseEntity.notFound().build();

	    	bookOptional.setPrice(book.getPrice());
	    	
	    	 bookStorageService.saveBookDetail(bookOptional);

	    	 return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Price of book has been changed"), HttpStatus.OK);
	    }
	 
	    
	    @PostMapping("/getBookByFilter")
	    public List<Book> getBookFilter(@RequestBody BookSearchDto book) {
	    	List<Book> bookList=new ArrayList<Book>();
	    if((book.getFromDate() !=null &&!book.getFromDate().equals("")))	{
	    
	    	try{
	    	bookList= bookStorageService.findBycreatedDate(new SimpleDateFormat("dd-M-yyyy HH:mm:ss").parse(book.getFromDate()+" 00:00:00"),new SimpleDateFormat("dd-M-yyyy HH:mm:ss").parse(book.getFromDate()+" 23:59:59"));
	    	}catch(Exception e){
	    		
	    	}
	    }else if((book.getAuthor()!=null&&!book.getAuthor().equals(""))||(book.getNumber()!=null &&!book.getNumber().equals(""))||book.getPrice()!=null && !book.getPrice().equals("")){
	    	bookList=bookStorageService.findByPriceNumberAuthor(book);
	    }else{
	    	bookList=bookStorageService.getAllBook();
	    }
	    
	    	return bookList;
	    
	    
	    }
	    
	    
	    
	    
	 
	 

}
