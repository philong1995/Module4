package com.codegym.service.Impl.contract;

import com.codegym.entity.contract.AttachService;
import com.codegym.repository.contract.AttachServiceRepository;
import com.codegym.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return this.attachServiceRepository.findAll();
    }
}
