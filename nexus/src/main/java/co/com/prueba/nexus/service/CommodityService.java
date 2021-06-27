package co.com.prueba.nexus.service;

import co.com.prueba.nexus.dto.CommodityDto;

import java.util.List;

public interface CommodityService {

    public List<CommodityDto> getComodities();

    public CommodityDto updateComodity(CommodityDto commodityDto) throws Exception;

    public void createComodity(CommodityDto commodityDto) throws Exception;

    public void deleteComodity(String productName) throws Exception;
}
