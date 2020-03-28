package com.bam.bs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bam.bs.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
