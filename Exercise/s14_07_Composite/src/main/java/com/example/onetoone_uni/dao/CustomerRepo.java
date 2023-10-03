package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.Customer;
import com.example.onetoone_uni.entity.CustomerId;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
