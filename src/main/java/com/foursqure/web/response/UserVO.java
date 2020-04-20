package com.foursqure.web.response;

import com.foursqure.web.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
public class UserVO {

    String userName;
    String firstName;
    String lastName;

    public static UserVO build(User user) {
        return UserVO
                .builder()
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public static User buildUser(UserVO userVO) {
        return User
                .builder()
                .userName(userVO.getUserName())
                .firstName(userVO.getFirstName())
                .lastName(userVO.getLastName())
                .build();
    }
}
