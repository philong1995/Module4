package com.codegym.entity.contract;

import com.codegym.entity.contract.ContractDetail;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer id;

    @Column(name = "attach_service_name")
    private String name;

    @Column(name = "attach_service_cost")
    private Double cost;

    @Column(name = "attach_service_unit")
    private Integer unit;

    @Column(name = "attach_service_status")
    private String status;

    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    public AttachService() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
