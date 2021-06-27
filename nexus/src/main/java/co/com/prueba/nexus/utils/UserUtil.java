package co.com.prueba.nexus.utils;

import co.com.prueba.nexus.dto.UserDto;
import co.com.prueba.nexus.entity.Position;
import co.com.prueba.nexus.entity.User;

public class UserUtil {

    public static UserDto convertUserToUserDto(User user){
        return UserDto.builder()
                .userName(user.getUserName())
                .userAge(user.getUserAge())
                .position(user.getPosition().getPositionName())
                .build();
    }

    public static User convertUserDtoToUser(Position position,UserDto userDto){
        return User.builder()
                .userAge(userDto.getUserAge())
                .userName(userDto.getUserName())
                .position(position)
                .build();
    }
}
