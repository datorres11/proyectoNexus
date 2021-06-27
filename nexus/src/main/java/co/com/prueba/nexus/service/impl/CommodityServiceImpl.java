package co.com.prueba.nexus.service.impl;

import co.com.prueba.nexus.dto.CommodityDto;
import co.com.prueba.nexus.entity.Commodity;
import co.com.prueba.nexus.entity.User;
import co.com.prueba.nexus.repository.ICommodityRepository;
import co.com.prueba.nexus.repository.IUserRepository;
import co.com.prueba.nexus.service.CommodityService;
import co.com.prueba.nexus.utils.CommodityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    ICommodityRepository iCommodityRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<CommodityDto> getComodities() {
        List<CommodityDto> commodityDtos = new ArrayList<>();
        List<Commodity> comodities = iCommodityRepository.findAll();
        for(Commodity commodity : comodities){
            commodityDtos.add(CommodityUtil.convertComodityToComodityDto(commodity));
        }
        return commodityDtos;
    }

    @Override
    public CommodityDto updateComodity(CommodityDto commodityDto) throws Exception {
        Optional<Commodity> comodity = iCommodityRepository.findByName(commodityDto.getProductName());
        Optional<User> user= iUserRepository.findByName(commodityDto.getUser());
        if(comodity.isPresent()){
            comodity.get().setUser(user.get());
            comodity.get().setProductAmount(commodityDto.getProductAmount());
            comodity.get().setModificationDate(commodityDto.getModificationDate());
            comodity.get().setModified_by(commodityDto.getModified_by());
            iCommodityRepository.save(comodity.get());
        }
        return commodityDto;
    }

    @Override
    public void createComodity(CommodityDto commodityDto) throws Exception {
        Optional<Commodity> comodity = iCommodityRepository.findByName(commodityDto.getProductName());
        if(comodity.isPresent()){
            throw new Exception("The name is already exists");
        }else {
            Optional<User> user= iUserRepository.findByName(commodityDto.getUser());
            iCommodityRepository.save(CommodityUtil.convertComodityDtoToComodity(user.get(),commodityDto));
        }
    }

    @Override
    public void deleteComodity(String productName) throws Exception {
        Optional<Commodity> comodity = iCommodityRepository.findByName(productName);
        if(comodity.isPresent()){
            iCommodityRepository.delete(comodity.get());
        }else{
            throw new Exception("Error while deleting, Commodity not found");
        }
    }
}
