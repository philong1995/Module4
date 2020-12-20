package com.codegym.entity.employee;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.login.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "employees")
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "employee_name")
    @NotBlank(message = "Name is not empty")
    private String name;

    @Column(name = "employee_birthday",columnDefinition = "DATE")
    private String birthday;

    @Column(name = "employee_id_card")
    @Pattern(regexp = "[0-9]{9}", message = "Wrong Format - XXXXXXXXX")
    private String idCard;

    @Column(name = "employee_salary")
    @NotNull(message = "Salary is not empty")
    private Double salary;

    @Column(name = "employee_phone")
    @Pattern(regexp = "(090|091)[0-9]{7}", message = "Wrong Format - (090|091))XXXXXX")
    private String phone;


    @Column(name = "employee_email")
    @Email(message = "email is not in the correct format")
    @NotBlank(message = "Email is not empty")
    private String email;

    @Column(name = "employee_address")
    @NotBlank(message = "Address is not empty")
    private String address;

    @ManyToOne
    @JoinColumn(name="position_id", referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name="education_degree_id", referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    private AppUser appUser;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Employee() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
