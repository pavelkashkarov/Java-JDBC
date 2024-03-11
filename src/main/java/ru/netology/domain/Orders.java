package ru.netology.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@ToString
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date DATE;
    private String product_name;
    private Integer amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customers customers;
}
