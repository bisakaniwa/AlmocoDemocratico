package com.dbserver.almoco.democratico.model;

import com.dbserver.almoco.democratico.model.dtos.RestaurantDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "email")
@Entity
public class HungryUser {

    @Column(nullable = false)
    private String name;

    @Id
    @Email
    private String email;

    @Pattern(regexp = "\\w{8,12}")
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "email",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Restaurant> addedRestaurants = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.lowerCase(name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = StringUtils.lowerCase(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Restaurant> getAddedRestaurants() {
        return addedRestaurants;
    }

    public void setAddedRestaurants(List<Restaurant> addedRestaurants) {
        this.addedRestaurants = addedRestaurants;
    }
}
