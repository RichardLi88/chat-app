package com.richard.chatapp.repositories;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.richard.chatapp.repository.UserRepository;
import com.richard.chatapp.user.Status;
import com.richard.chatapp.user.User;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryIntegrationTests {
  private UserRepository testRepository;

  @Autowired
  public UserRepositoryIntegrationTests(UserRepository testRepository) {
    this.testRepository = testRepository;
  }

  @Test
  public void testThatAuthorCanBeCreatedAndRecalled(){
    User user = User.builder()
                    .username("John Doe")
                    .firstName("John")
                    .lastName("Doe")
                    .status(Status.ONLINE)
                    .build();
    testRepository.save(user);
    Optional<User> result = testRepository.findById(user.getId());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(user);

  }



}
