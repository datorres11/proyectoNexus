package co.com.prueba.nexus.service.impl;

import co.com.prueba.nexus.dto.PositionDto;
import co.com.prueba.nexus.entity.Position;
import co.com.prueba.nexus.repository.IPositionRepository;
import co.com.prueba.nexus.service.PositionService;
import co.com.prueba.nexus.utils.PositionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public List<PositionDto> getPositions() {
        List<PositionDto> positionDtos = new ArrayList<>();
        List<Position> positions = iPositionRepository.findAll();
        for(Position position:positions){
            positionDtos.add(PositionUtil.convertPositionToPositionDto(position));
        }
        return positionDtos;
    }

    @Override
    public void createPosition(PositionDto positionDto) {
        iPositionRepository.save(PositionUtil.convertPositionDtoToPosition(positionDto));
    }

    @Override
    public void deletePosition(String positionName) {
        Optional<Position> position = iPositionRepository.findByName(positionName);
        if(position.isPresent()){
            iPositionRepository.delete(position.get());
        }
    }
}
