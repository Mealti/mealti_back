package com.mealti.demo.service;

import com.mealti.demo.domain.User;
import com.mealti.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long singUp(User user){

        validateDuplicateUser(user); // 중복 회원 검사
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user){
        List<User> findUsers = userRepository.findByEmail(user.getEmail());
        if(!findUsers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public User findOne(Long UserId){
        return userRepository.findOne(UserId);
    }

}
