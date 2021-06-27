package co.com.prueba.nexus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@Data
@Entity
@Table(name = "commodity")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1,sequenceName = "commodity_id_seq", name = "COMMODITY_ID_SEQ",allocationSize = 1)
public class Commodity {

    @Id
    @Column(name = "commodity_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="COMMODITY_ID_SEQ")
    private Integer commodityId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_amount")
    private Integer productAmount;

    @Column(name="date_of_admission")
    private Date dateOfAdmission;

    @Column(name="modification_date")
    private Date modificationDate;

    @Column(name="modified_by")
    private String modified_by;

    @ManyToOne
    @JoinColumn(name="user_nexus")
    private User user;

}
