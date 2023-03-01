package com.example.akkar2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RealEstate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRealEstate;

    @Column(nullable = false)
    private String location;
    @Lob
    private byte[] pictures;
   private double pricePerNight;
// A verifier le type des images
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RealEstateType type;

    @Column(nullable = false)
    private  String services;
    @Column(nullable = false)
    private int surface;
    @Column(nullable = false)
    private int rooms;
    @Column(nullable = false)
    private int floors;
    @Column(nullable = false)
    private  String description;

    @OneToOne
    @JsonIgnore
    private Announcement announcement;
    @OneToOne
    @JsonIgnore
    private Papers paper;
    @OneToMany(mappedBy = "realEstate")
    @JsonIgnore
    private List<Contract> contracts;
    @OneToMany(mappedBy = "realEstate")
    @JsonIgnore
    private  List<Reservation> reservations;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Rating> ratings;
    

}
