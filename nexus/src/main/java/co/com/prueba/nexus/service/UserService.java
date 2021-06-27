package co.com.prueba.nexus.service;

import co.com.prueba.nexus.dto.PositionDto;
import co.com.prueba.nexus.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> getUsers();

    public void createUser(UserDto userDto);

    public void deleteUser(String userName);
}
