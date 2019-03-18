package com.bookstore.controller;

import static org.springframework.data.jpa.domain.Specifications.where;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BookListSpecification extends BaseSpecification<Book, BookSearchDto> {

	@Override
	public Specification<Book> getFilter(BookSearchDto request) {
		  return (root, query, cb) -> {
			 query.distinct(true);
			  return where(
		                where(authorContains(request.getAuthor()))
		                    .or(numberContains(request.getNumber()))
		                    .or(priceContains(request.getPrice()))
		                        
		            ).
					  toPredicate(root, query, cb);
			  
		  };
	}
	
	 private Specification<Book> authorContains(String author) {
	        return userAttributeContains("author", author);
	    }
	 private Specification<Book> numberContains(String number) {
	        return userAttributeContains("id", number);
	    }
	
	 private Specification<Book> priceContains(String price) {
	        return piceAttributeContains("price", price);
	    }
	
	private Specification<Book> userAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }
 
            return cb.like(
                cb.lower(root.get(attribute)),
                containsLowerCase(value)
            );
        };
    }
	
	
	
	
	private Specification<Book> piceAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }
 
            return cb.equal(
                cb.lower(root.get(attribute)),new BigDecimal(value)
                
            );
        };
    }
 
	
	
	
	
	
	
}
