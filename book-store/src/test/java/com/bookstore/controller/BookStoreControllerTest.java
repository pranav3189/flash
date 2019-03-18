package com.bookstore.controller;

import static java.util.Collections.singletonList;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = BookStoreController.class, secure = false)
public class BookStoreControllerTest {
	private static final MediaType APPLICATION_JSON = null;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookStorageService bookStorageService;
	@MockBean
	private FileStorageService fileStorageService;
	
	@Test
	public void createBook() throws Exception {
		 final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.png");
		 final MockMultipartFile avatar = new MockMultipartFile("file", "test.png", "multipart/form-data", inputStream);
		 Book book=new Book(1l, "HarryPotter", new BigDecimal(90.00),new Date(), "abc");
		 String bookJson = "{\"fileName\":\"HarryPotter\",\"status\":\"Success\",\"code\":\"1\"}";
		 Mockito.when(bookStorageService.saveBookDetail(Mockito.any(Book.class))).thenReturn(book);
		 MvcResult result =mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/uploadBook").file(avatar).content(bookJson)).andExpect(status().isOk()).andReturn();
		 Mockito.when(fileStorageService.storeFile(avatar)).thenReturn("");
		
	}
	
	 @Test
	   public void getArrivals() throws Exception {
		 Book book=new Book(1l, "HarryPotter", new BigDecimal(90.00),new Date(), "abc");
	       List<Book> allArrivals=new ArrayList<Book>();
	       allArrivals.add(book);
	       String bookJson = "{\"id\":\"1l\",\"name\":\"HarryPotter\",\"price\":\"30.0\",\"createdDate\":\"2018-11-20\",\"author\":\"shiv\"}";
	       
	       
	       Mockito.when(
	    		   bookStorageService.getAllBook()).thenReturn(allArrivals);

	       RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
	    		   "/api/getAllBook").accept(
					MediaType.APPLICATION_JSON);
	       MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	       String expected = "[{id:1,name:HarryPotter,price:90.0}]";
	       JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
	   }

	
	
	
	
	
	
}
