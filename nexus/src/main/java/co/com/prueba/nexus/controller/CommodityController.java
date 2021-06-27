package co.com.prueba.nexus.controller;

import co.com.prueba.nexus.dto.CommodityDto;
import co.com.prueba.nexus.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @GetMapping("/commodities")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(commodityService.getComodities());
    }

    @PostMapping()
    public ResponseEntity<?> createComodity(@RequestBody CommodityDto commodityDto)throws Exception{
        try{
            commodityService.createComodity(commodityDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateComodity(@RequestBody CommodityDto commodityDto){
        try{
            return new ResponseEntity<>(commodityService.updateComodity(commodityDto),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{comodityName}")
    public ResponseEntity<?> deleteComodity(@PathVariable String comodityName){
        try{
            commodityService.deleteComodity(comodityName);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.CONFLICT);
        }
    }
}
