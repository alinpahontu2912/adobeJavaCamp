package com.adobe.adobeCamp.services;

import mystageservice.domain.Critique;
import mystageservice.domain.User;
import mystageservice.repository.ShowRepository;
import mystageservice.repository.UserRepository;
import mystageservice.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ShowRepository showRepository;
    @InjectMocks
    private UserService userService;
    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Test
    public void test_addUser() {
        // given
        Critique user = Critique.builder().name("Alin").build();
        Mockito.when(userRepository.findFirstByName("Alin")).thenReturn(null);
        Mockito.when(userRepository.save(eq(user))).thenReturn(user);

        // when
        User result = userService.addUser(user, "safasasd");

        // then
        assertNotNull("result should not be null", result);
        assertEquals("wrong result", user, result);
    }



}
