package com.richard.chatapp.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.richard.chatapp.entities.User;
import com.richard.chatapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ActiveProfiles("test")
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerTests {
  @Mock
  private UserService service; // Mock the service

  @InjectMocks
  private UserController userController; // Inject the mock service into the controller

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    // Setup MockMvc for controller testing
    mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
  }

  /**
   * Test that user is being returned when calling the GET method
   * @throws Exception
   */
  @Test
  void testFindUser_UserFound() throws Exception {
    // Arrange: Mock the service to return a user
    User user = User.builder().username("johndoe").firstName("John").lastName("Doe").build();
    when(service.findByUsername("johndoe")).thenReturn(user);

    // Act: Make the GET request to the endpoint
    mockMvc.perform(get("/get/user")
            .param("username", "johndoe")
            .param("firstname", "John")
            .param("lastname", "Doe"))
        .andExpect(status().isOk())  // Expect HTTP 200
        .andExpect(jsonPath("$.username").value("johndoe"))  // Check if username is returned
        .andExpect(jsonPath("$.firstName").value("John"))   // Check if first name is returned
        .andExpect(jsonPath("$.lastName").value("Doe"));    // Check if last name is returned
  }

  /**
   * Test that create new user is being called when user is not found in db
   * @throws Exception
   */
  @Test
  void testFindUser_UserNotFound() throws Exception {
    // Arrange: Mock the service to return null (no user found)
    when(service.findByUsername("johndoe")).thenReturn(null);

    // Mock saveUser to return the new user when called
    User newUser = User.builder().username("johndoe").firstName("John").lastName("Doe").build();
    when(service.saveUser(any(User.class))).thenReturn(newUser);

    // Act: Make the GET request to the endpoint
    mockMvc.perform(get("/get/user")
            .param("username", "johndoe")
            .param("firstname", "John")
            .param("lastname", "Doe"))
        .andExpect(status().isOk())  // Expect HTTP 200 (new user is created)
        .andExpect(jsonPath("$.username").value("johndoe"))  // Check if username is returned
        .andExpect(jsonPath("$.firstName").value("John"))   // Check if first name is returned
        .andExpect(jsonPath("$.lastName").value("Doe"));    // Check if last name is returned
  }
}
