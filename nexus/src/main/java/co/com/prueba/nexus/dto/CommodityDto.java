package co.com.prueba.nexus.dto;

import co.com.prueba.nexus.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CommodityDto {

    private String productName;

    private Integer productAmount;

    private Date dateOfAdmission;

    private Date modificationDate;

    private String user;

    private String modified_by;
}
