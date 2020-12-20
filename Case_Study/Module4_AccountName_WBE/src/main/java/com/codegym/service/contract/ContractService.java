package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.contract.ContractDetail;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    Contract findById(Integer id);
    void save(Contract contract);
    void delete(Integer id);
}
