package com.bam.bs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.bam.bs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    void deleteAllById(Long[] id);

    Optional<User> findUserByUserName(String userName);
    
}
