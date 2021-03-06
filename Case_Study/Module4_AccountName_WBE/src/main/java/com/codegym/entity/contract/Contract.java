package com.codegym.entity.contract;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.service.Service;
import com.codegym.entity.employee.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;

    @Column(name = "contract_start_date",columnDefinition = "DATETIME")
    private String startDate;

    @Column(name = "contract_end_date",columnDefinition = "DATETIME")
    private String endDate;

    @Column(name = "contract_deposit")
    private Double deposit;

    @Column(name = "contract_total_money")
    private Double totalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "service_id")
    private Service service;

    public Contract() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        try {
            LocalDate startDate = LocalDate.parse(contract.getStartDate());
            LocalDate endDate = LocalDate.parse(contract.getEndDate());
            if (endDate.compareTo(startDate) <= 0) {
                errors.rejectValue("endDate", "date.regex");
            }
        }catch (Exception e){
            errors.rejectValue("endDate", "date.empty");
            errors.rejectValue("startDate", "date.empty");
        }
    }
}
