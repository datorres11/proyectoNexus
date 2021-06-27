package co.com.prueba.nexus.utils;

import co.com.prueba.nexus.dto.PositionDto;
import co.com.prueba.nexus.entity.Position;

public class PositionUtil {

    public static Position convertPositionDtoToPosition(PositionDto positionDto){
        return Position.builder()
                .positionName(positionDto.getPositionName())
                .build();

    }

    public static PositionDto convertPositionToPositionDto(Position position){
        return PositionDto.builder()
                .positionName(position.getPositionName())
                .build();
    }
}
