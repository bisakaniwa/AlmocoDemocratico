package com.dbserver.almoco.democratico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "stateId")
@Entity
public class BrazilState {

    @Id
    @Column(name = "state")
    private String state;


    @OneToMany(mappedBy = "state",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<BrazilCity> stateCities = new ArrayList<>();

}
