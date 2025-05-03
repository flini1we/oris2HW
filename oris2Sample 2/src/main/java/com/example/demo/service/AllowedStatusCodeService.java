package com.example.demo.service;

import com.example.demo.entity.AllowedStatusCode;
import com.example.demo.repository.AllowedStatusCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AllowedStatusCodeService {
    @Autowired
    private AllowedStatusCodeRepository repository;

    public List<AllowedStatusCode> findAll() {
        return repository.findAll();
    }

    public boolean isAllowed(Integer code) {
        return repository.existsByCode(code);
    }

    public void addCode(Integer code) {
        if (!repository.existsByCode(code)) {
            AllowedStatusCode asc = new AllowedStatusCode();
            asc.setCode(code);
            repository.save(asc);
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
} 