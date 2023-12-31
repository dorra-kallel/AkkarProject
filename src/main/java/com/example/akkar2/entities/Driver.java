package com.example.akkar2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@DiscriminatorValue("D")

public class Driver extends User implements Serializable {

    @Column
    private boolean status = Boolean.FALSE;
    @Column(nullable = false)
    private int phoneNumber;

    @Column(nullable = true)
    private float driverPrice;

    @Column(nullable = true)
    private String driverLocation;

    @Column(nullable = true)
    private String truckType;

    @Column(nullable = true)
    private double cabinCapacity;


    //TransportationDemand
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private List<TransportationDemand> transportationDemand;

   /*
    //offers
    @JsonIgnore
    @ManyToMany
    private List<Offer> offers;*/
    //offre bech tetnaha
}