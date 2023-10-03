package com.example.onetoone_uni.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerId implements Serializable {
    UserId userId;
    String customerNumber;

    //implements equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerId that = (CustomerId) o;

        if (!Objects.equals(userId, that.userId)) return false;
        return Objects.equals(customerNumber, that.customerNumber);
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (customerNumber != null ? customerNumber.hashCode() : 0);
        return result;
    }
}

