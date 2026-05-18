package com.communityhub.demo;

import com.communityhub.demo.user.entity.User;
import com.communityhub.demo.user.repository.UserRepository;
import com.communityhub.demo.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserTestMockito {
   @Mock
    UserRepository userRepository;
   @BeforeEach
    void mocking(){
       System.out.println("mocking");

   }
   @InjectMocks
    UserService userService;

   @Test
    void shouldReturnNameById(){
       User user=new User("Ask",1,"asdf");
       when(userRepository.findById(1L))
               .thenReturn(Optional.of(user));
       User result=userService.getUser(1L);
       assertEquals("Ask",result.getName());

   }

}
