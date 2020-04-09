package com.bam.bs.repository;

import java.util.List;

import com.bam.bs.entity.Customer;
import com.bam.bs.util.CustomerType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByCustomerType(CustomerType customerType);

    List<Customer> findByNameLikeIgnoreCase(String name);

    void deleteAllById(Long[] ids);

}
