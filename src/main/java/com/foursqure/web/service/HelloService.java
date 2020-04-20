package com.foursqure.web.service;

import com.foursqure.web.entity.User;
import com.foursqure.web.repository.UserRepository;
import com.foursqure.web.response.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class HelloService {

    @Autowired
    UserRepository userRepository;

    public void updateUser(User user) {
        // do something nasty...
        System.out.println("in service class: " + user);
        userRepository.save(user);
    }

    public Optional<User> getUser(String userName) {
        return userRepository.findById(userName);
    }
}
