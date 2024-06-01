package Hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "equity")
public class EquityDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "equity_name")
    private String equityName;

    @Column(name = "category")
    private String category;
}
