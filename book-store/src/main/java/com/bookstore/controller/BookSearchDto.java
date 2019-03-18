package com.bookstore.controller;

import java.math.BigDecimal;
import java.util.Date;

public class BookSearchDto {
	 
	    
	    private String fromDate;
	    private String toDate;
	    private String createdDate;
	    
	    private String author;
	    private String price;
	    private String number;
		
		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}
		public String getToDate() {
			return toDate;
		}
		public void setToDate(String toDate) {
			this.toDate = toDate;
		}
		public String getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
	    
	    
	    
	  
}
