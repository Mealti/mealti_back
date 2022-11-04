package com.mealti.demo.service;

import com.mealti.demo.domain.User;
import com.mealti.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Test
    public void 회원가입() throws Exception {
        //Given
        User user = new User();
        user.setName("yoonkyeong");
        //When
        Long saveId = userService.singUp(user);
        //Then
        assertEquals(user, userRepository.findOne(saveId));
    }
    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        User user1 = new User();
        user1.setName("yoonkyeong");
        User user2 = new User();
        user2.setName("yoonkyeong");
        //When
        userService.singUp(user1);
        userService.singUp(user2); //예외가 발생해야 한다.
        //Then
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> userService.singUp(user2));
        assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
    }

}