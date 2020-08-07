package com.spring.corona_1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.corona_1.controller.AuthController;
import com.spring.corona_1.model.MailMessage;
import com.spring.corona_1.model.User;
import com.spring.corona_1.repo.RoleRepository;
import com.spring.corona_1.repo.UserRepository;
import com.spring.corona_1.security.jwt.JwtUtils;
import com.spring.corona_1.service.MailService;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityJwtExampleApplicationTests {
	
	@Autowired
	private AuthController authController ;
	
    @Autowired                           
    private MockMvc mockMvc;  
                                                 
//    @MockBean                           
//    private UserService userService; 
    
    @MockBean 
	UserRepository userRepository;
                                               
//    private List<User> userList;  


	@Test
	public void contextLoads() throws Exception {
		assertThat(authController).isNotNull();
	}
	
	
	@Test 
	void createUser() throws Exception {
		String s="User registered successfully!";
		User user = new User("JunitTest", "junit@gmail.com", "password");
		ObjectMapper objectMapper=new ObjectMapper();
		this.mockMvc.perform(post("/api/auth/signup")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.message", is(s)))	
				;
	}
	
	@Test
	void getAllLocationTest () throws Exception {
		mockMvc.perform(get("/api/location/getAllMarkers"));
	}

	
	@Test
	void getAllLocationTestFinal () throws Exception {
		mockMvc.perform(get("/api/location/getAllFinalMarkers"));
	}
	
	
	

}
