package com.codegym.service.Impl.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return this.contractRepository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return this.contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }

    @Override
    public void delete(Integer id) {
        this.contractRepository.deleteById(id);
    }
}
