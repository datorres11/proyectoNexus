package co.com.prueba.nexus.controller;

import co.com.prueba.nexus.dto.PositionDto;
import co.com.prueba.nexus.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/positions")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(positionService.getPositions());
    }

    @PostMapping()
    public ResponseEntity<?> createPosition(@RequestBody PositionDto positionDto){
        try{
            positionService.createPosition(positionDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{positionName}")
    public ResponseEntity<?> deletePosition(@PathVariable String positionName){
        try{
            positionService.deletePosition(positionName);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.CONFLICT);
        }
    }
}
