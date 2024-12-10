package com.example.aseel.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class RealEstateDev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Please enter name of company")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String companyName;
    @NotEmpty(message = "Please enter phone of company")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;
    @NotEmpty(message = "Please enter email of company")
    @Email
    @Column(columnDefinition = "varchar(40) not null unique")
    private String companyEmail;
    @NotEmpty(message = "Please enter the commercial record")
    @Column(columnDefinition = "varchar(10) not null")
    private String commercialRecord;
    @NotEmpty(message = "Enter your assets")
    @Column(columnDefinition = "varchar(50) not null")
    private String assets;

    public String getCommercialRecord() {
        return commercialRecord;
    }

    public void setCommercialRecord(String commercialRecord) {
        this.commercialRecord = commercialRecord;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
