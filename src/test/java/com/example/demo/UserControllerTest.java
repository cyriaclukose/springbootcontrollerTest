package com.example.demo;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.Usercontroller;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(Usercontroller.class)
public class UserControllerTest {
	
	@Autowired
	private Usercontroller usercontroller;
	
	@Autowired
	private  MockMvc mvc;
	
	@MockBean
	private UserService userservice;
	
	@Test
	public void testUserById() throws Exception
	{
		//mock the service layer
		
		User user = new User(1,"john","luke");
		
		Mockito.when(userservice.getUserById(1)).thenReturn(user);
		
		//now make the http call
		
	     mvc.perform(MockMvcRequestBuilders.get("/user/1")).andDo(print()).
	     andExpect(content().contentType("application/json")).
	     andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("john")).
	     andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("luke")).
	     andExpect(status().isOk());
	     
	    
	  
	}
	
	@Test
	public void testSaveUser() throws Exception
	{

		
		User user = new User(1,"john","luke");
		
		Mockito.when(userservice.saveUser(Mockito.any(User.class))).thenReturn(user);
		

	     mvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user))).andDo(print()).
	     andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("john")).
	     andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("luke")).
	     andExpect(status().isCreated());
	     

	}
}
