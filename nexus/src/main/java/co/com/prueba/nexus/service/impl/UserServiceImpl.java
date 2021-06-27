package co.com.prueba.nexus.service.impl;

import co.com.prueba.nexus.dto.UserDto;
import co.com.prueba.nexus.entity.Position;
import co.com.prueba.nexus.entity.User;
import co.com.prueba.nexus.repository.IPositionRepository;
import co.com.prueba.nexus.repository.IUserRepository;
import co.com.prueba.nexus.service.UserService;
import co.com.prueba.nexus.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = iUserRepository.findAll();
        for(User user : users){
            userDtos.add(UserUtil.convertUserToUserDto(user));
        }
        return userDtos;
    }

    @Override
    public void createUser(UserDto userDto) {
        Optional<Position> position = iPositionRepository.findByName(userDto.getPosition());
        iUserRepository.save(UserUtil.convertUserDtoToUser(position.get(),userDto));
    }

    @Override
    public void deleteUser(String userName) {
        Optional<User> user= iUserRepository.findByName(userName);
        if(user.isPresent()){
            iUserRepository.delete(user.get());
        }
    }
}
