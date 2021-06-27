package co.com.prueba.nexus.service;

import co.com.prueba.nexus.dto.CommodityDto;
import co.com.prueba.nexus.dto.PositionDto;
import co.com.prueba.nexus.dto.UserDto;
import co.com.prueba.nexus.entity.Commodity;
import co.com.prueba.nexus.entity.Position;
import co.com.prueba.nexus.entity.User;
import co.com.prueba.nexus.repository.IUserRepository;
import org.assertj.core.api.AssertionInfo;
import org.assertj.core.description.Description;
import org.assertj.core.presentation.Representation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    CommodityService commodityService;

    @Autowired
    UserService userService;

    @Autowired
    PositionService positionService;

    @Test
    public void createCommodity() {
        CommodityDto commodityDto;
        try {
            commodityDto = CommodityDto.builder()
                    .productName("Puertas")
                    .productAmount(26)
                    .dateOfAdmission(new Date())
                    .user("Andres Perez").build();
            commodityService.createComodity(commodityDto);
        }catch(Exception e){
            new AssertionError(e.getMessage());
        }
    }

    @Test
    public void updateCommodity() {
        CommodityDto commodityDto;
        try {
            commodityDto = CommodityDto.builder()
                    .productName("Puertas")
                    .productAmount(26)
                    .dateOfAdmission(new Date())
                    .user("Andres Perez")
                    .modificationDate(new Date())
                    .modified_by("Juan Galindo").build();
            commodityService.updateComodity(commodityDto);
        }catch(Exception e){
            new AssertionError(e.getMessage());
        }
    }

    @Test
    public void deleteCommodity() {
        try {
            commodityService.deleteComodity("Puertas");
        }catch(Exception e){
            new AssertionError(e.getMessage());
        }
    }

    @Test
    public void createUser(){
        UserDto userDto;
        userDto= UserDto.builder()
                 .userName("Armando Casas")
                 .userAge(21)
                 .position("soporte")
                 .build();
        userService.createUser(userDto);
    }

    @Test
    public void deleteUser(){
        userService.deleteUser("Armando Casas");
    }

    @Test
    public void createPosition(){
        PositionDto positionDto;
        positionDto = PositionDto.builder()
                .positionName("Tecnico").build();
        positionService.createPosition(positionDto);
    }

    @Test
    public void deletePosition(){
        positionService.deletePosition("Tecnico");
    }
}
