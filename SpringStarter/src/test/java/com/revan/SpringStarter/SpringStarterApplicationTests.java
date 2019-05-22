package com.revan.SpringStarter;

import com.revan.SpringStarter.dao.UserRepository;
import com.revan.SpringStarter.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringStarterApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserRepository repository;

	private final static String URL = "/users/";
	private final static Long ID     = 1L;
	private static User USER  = new User("Test User", "No Role");

	@Test
	public void contextLoads() throws Exception {
//		getAllUsersTest();
//		getOneUserTest();
//		createOneUserTest();
//		updateOneUserTest();
		deleteOneUserTest();
	}


	private void getAllUsersTest() throws Exception {
		when(repository.findAll()).thenReturn(Collections.emptyList());
		MvcResult mvcResult = mvc.perform(get(URL).accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println(mvcResult.getResponse());

		verify(repository).findAll();
	}

	private void getOneUserTest() throws Exception {
		when(repository.findAll()).thenReturn(Collections.emptyList());
		MvcResult mvcResult = mvc.perform(get(URL + "/" + ID).accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println(mvcResult.getResponse());

		verify(repository).findById(ID);
	}

	private void createOneUserTest() throws Exception {
		when(repository.findAll()).thenReturn(Collections.emptyList());
		MvcResult mvcResult = mvc.perform(post(URL).param("name", USER.getName()).param("role", USER.getRole()).accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println(mvcResult.getResponse());

		verify(repository).findById(USER.getId());
	}

	private void updateOneUserTest() throws Exception {
		when(repository.findAll()).thenReturn(Collections.emptyList());
		MvcResult mvcResult = mvc.perform(put(URL).param("name", USER.getName()).param("role", "Gardener").accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println(mvcResult.getResponse());

		verify(repository).findAll();
	}

	private void deleteOneUserTest() throws Exception {
		when(repository.findAll()).thenReturn(Collections.emptyList());
		MvcResult mvcResult = mvc.perform(delete(URL + "/" + USER.getId()).accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println(mvcResult.getResponse());

		verify(repository).findAll();
	}
}
