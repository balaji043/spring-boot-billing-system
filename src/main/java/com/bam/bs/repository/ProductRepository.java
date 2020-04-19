package com.bam.bs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bam.bs.model.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
