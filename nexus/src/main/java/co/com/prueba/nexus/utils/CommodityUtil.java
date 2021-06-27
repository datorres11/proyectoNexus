package co.com.prueba.nexus.utils;

import co.com.prueba.nexus.dto.CommodityDto;
import co.com.prueba.nexus.entity.Commodity;
import co.com.prueba.nexus.entity.User;
import co.com.prueba.nexus.repository.ICommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommodityUtil {

    public static CommodityDto convertComodityToComodityDto(Commodity commodity){
        return CommodityDto.builder()
                .productName(commodity.getProductName())
                .productAmount(commodity.getProductAmount())
                .dateOfAdmission(commodity.getDateOfAdmission())
                .user(commodity.getUser().getUserName())
                .build();
    }

    public static Commodity convertComodityDtoToComodity(User user, CommodityDto commodityDto){
        return Commodity.builder()
                .productName(commodityDto.getProductName())
                .productAmount(commodityDto.getProductAmount())
                .dateOfAdmission(commodityDto.getDateOfAdmission())
                .user(user)
                .build();
    }
}
