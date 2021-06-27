package co.com.prueba.nexus.dto;

import co.com.prueba.nexus.entity.Position;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String userName;

    private Integer userAge;

    private String position;
}
