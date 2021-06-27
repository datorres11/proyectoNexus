package co.com.prueba.nexus.service;

import co.com.prueba.nexus.dto.PositionDto;

import java.util.List;

public interface PositionService {

    public List<PositionDto> getPositions();

    public void createPosition(PositionDto positionDto);

    public void deletePosition(String positionName);
}
