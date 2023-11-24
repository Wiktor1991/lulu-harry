package com.example.luluharry.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;


import java.util.List;
import java.util.Map;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer articleNumber;
    private Integer stkNumber;
    private Integer weight;
    private String picture;
    @MapKeyEnumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(name="orders", joinColumns=@JoinColumn(name="articleNumber"))
    @Column(name="orders")
    @MapKeyJoinColumn(name="day", referencedColumnName="day")
    private Map<Day,Integer> orders;
}
