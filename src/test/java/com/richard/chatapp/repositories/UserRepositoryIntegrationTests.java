package com.richard.chatapp.repositories;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.richard.chatapp.repository.UserRepository;
import com.richard.chatapp.entities.Status;
import com.richard.chatapp.entities.User;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryIntegrationTests {

  private final UserRepository underTest;

  @Autowired
  public UserRepositoryIntegrationTests(UserRepository underTest) {
    this.underTest = underTest;
  }

  @Test
  public void testThatAuthorCanBeCreatedAndRecalled(){
    User user = User.builder()
                    .username("John Doe")
                    .firstName("John")
                    .lastName("Doe")
                    .status(Status.ONLINE)
                    .build();
    underTest.save(user);
    Optional<User> result = underTest.findById(user.getId());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(user);

  }

  @Test
  public void testThatFindAllByStatusReturnsCorrectly(){
    User user = User.builder()
        .username("John Doe")
        .firstName("John")
        .lastName("Doe")
        .status(Status.ONLINE)
        .build();
    underTest.save(user);
    List<User> result = underTest.findAllByStatus(Status.ONLINE);
    assertThat(!result.isEmpty());
    assertThat(result.getFirst()).isEqualTo(user);
  }


}
