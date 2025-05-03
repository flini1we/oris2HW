package com.example.demo.repository;

import com.example.demo.entity.AllowedStatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
 
public interface AllowedStatusCodeRepository extends JpaRepository<AllowedStatusCode, Long> {
    Optional<AllowedStatusCode> findByCode(Integer code);
    boolean existsByCode(Integer code);
} 