package com.example.aseel.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class RealEstateDev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CR;
    @NotEmpty(message = "Please enter name of company")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String companyName;
    @NotEmpty(message = "Please enter phone of company")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String companyPhone;
    @NotEmpty(message = "Please enter email of company")
    @Email
    @Column(columnDefinition = "varchar(40) not null unique")
    private String companyEmail;

    public Integer getCR() {
        return CR;
    }

    public void setCR(Integer CR) {
        this.CR = CR;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
