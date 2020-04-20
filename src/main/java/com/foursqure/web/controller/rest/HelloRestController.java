package com.foursqure.web.controller.rest;

import com.foursqure.web.entity.User;
import com.foursqure.web.response.UserVO;
import com.foursqure.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest/api")
public class HelloRestController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/sayHello/{firstName}/{lastName}")
    public String sayHello(@PathVariable(required = false) String firstName, @PathVariable(required = false) String lastName) {
        return "Hello, " + firstName + " " + lastName;
    }

    @RequestMapping(value = "/getUser/{userName}", method = GET, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public UserVO getUser(@PathVariable String userName) {
        Optional<User> user = helloService.getUser(userName);
        if (user.isPresent()) {
            return UserVO.build(user.get());
        }
        throw new IllegalArgumentException("Invalid UserName");
    }

    @RequestMapping(value = "/updateUser", consumes = APPLICATION_JSON_VALUE, method = POST)
    public void updateUser(@RequestBody UserVO userVO) {
        // get user from db by id
        // set new values
        // update user in db
        helloService.updateUser(UserVO.buildUser(userVO));
    }
}
