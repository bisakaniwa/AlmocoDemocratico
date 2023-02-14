package com.dbserver.almoco.democratico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cityId")
@Data
@Entity
public class BrazilCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long cityId;

    private String cityName;

    @JsonIgnore
    @Column(name = "state", nullable = false)
    private String state;
}
