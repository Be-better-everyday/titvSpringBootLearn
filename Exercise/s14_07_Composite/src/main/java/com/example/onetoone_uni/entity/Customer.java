package com.example.onetoone_uni.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @EmbeddedId CustomerId id;
    boolean preferredCustomer;

    @MapsId("userId")
    @JoinColumns({
            @JoinColumn(name="userfirstname_fk", referencedColumnName="first_name"),
            @JoinColumn(name="userlastname_fk", referencedColumnName="last_name")
    })
    @OneToOne User user;
}

