package com.bookstore.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Book")
public class Book implements Serializable{
	
    private Long id;

    private String name;

    private BigDecimal price;
    
    private Date createdDate;
    
  //  private MultipartFile file;
    
    private String author;
    
    
    
    public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Book(Long id, String name, BigDecimal price, Date createdDate, String author) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.createdDate = createdDate;
		//this.file = file;
		this.author = author;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	@Column(name = "author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/*@Transient
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}*/
   
	
	
    
    
}
