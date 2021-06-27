package co.com.prueba.nexus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1,sequenceName = "position_id_seq", name = "POSITION_ID_SEQ",allocationSize = 1)
public class Position {

    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="POSITION_ID_SEQ")
    private Integer positionId;

    @Column(name="position_name")
    private String positionName;
}
