package co.com.prueba.nexus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "user_nexus")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1,sequenceName = "user_id_seq", name = "USER_ID_SEQ",allocationSize = 1)
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="USER_ID_SEQ")
    private Integer userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_age")
    private Integer userAge;

    @OneToOne
    @JoinColumn(name="user_position")
    private Position position;

}
