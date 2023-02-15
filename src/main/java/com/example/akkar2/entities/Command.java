package com.example.akkar2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Command  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long commandId;

    Double quantity;
    @Temporal(TemporalType.DATE)
    Date commandDate;
    Double totalPrice;
    Boolean payementStatus;

    @OneToOne
    private Furniture furniture;
   // OneToMany(mappedBy="")
    //  Set<Client>clients;
   @ManyToOne
   @JsonIgnore
   private User user;

}