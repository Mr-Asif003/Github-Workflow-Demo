package com.communityhub.demo;

import com.communityhub.demo.user.entity.User;
import com.communityhub.demo.user.repository.UserRepository;
import com.communityhub.demo.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @DisplayName("should return user when id exists")
   @Test
    void shouldReturnUserWhenIdExists(){
      User user=new User("Asif",1L,"ak@");
      when(repository.findById(1L))
              .thenReturn(Optional.of(user));
      User result=service.getUser(1L);
      assertEquals("Asif",result.getName());
       verify(repository).findById(1L);
     }
     @DisplayName("should register seccessfully")
    @Test
    void shouldRegisterUserSuccessfully(){
         User user = new User("Asif Khan", 2L, "@gmail");

         // User does not already exist
         when(repository.findByEmail("@gmail"))
                 .thenReturn(Optional.empty());

         // Mock save operation
         when(repository.save(user))
                 .thenReturn(user);

         User result = service.registerUser(user);

         assertNotNull(result);
         assertEquals(user.getId(), result.getId());
         assertEquals(user.getEmail(), result.getEmail());

         verify(repository).save(user);
     }

}
