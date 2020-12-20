package com.codegym.service.Impl.contract;

import com.codegym.entity.contract.ContractDetail;
import com.codegym.repository.contract.ContractDetailRepository;
import com.codegym.service.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Integer id) {
        return this.contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(Integer id) {
        this.contractDetailRepository.deleteById(id);
    }
}
