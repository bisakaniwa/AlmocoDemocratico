package com.dbserver.almoco.democratico.model.dtos;

import com.dbserver.almoco.democratico.model.Restaurant;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RestaurantDTO {
    private String name;

    private String description;

    private String address;

    private String addressComplement;

    private String addressNumber;

    private String district;

    private String city;

    private String cep;

    private String website;

    private int numVotes = 0;
    public RestaurantDTO(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.description = restaurant.getDescription();
        this.address = restaurant.getAddress();
        this.addressComplement = restaurant.getAddressComplement();
        this.addressNumber = restaurant.getAddressNumber();
        this.district = restaurant.getDistrict();
        this.city = restaurant.getCity();
        this.cep = restaurant.getCep();
        this.website = restaurant.getWebsite();
        this.numVotes = restaurant.getNumVotes();
    }
}
