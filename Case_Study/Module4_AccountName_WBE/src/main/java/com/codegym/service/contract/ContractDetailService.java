package com.codegym.service.contract;

import com.codegym.entity.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    ContractDetail findById(Integer id);
    void save(ContractDetail contractDetail);
    void delete(Integer id);
}
