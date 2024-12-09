package com.example.aseel.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;



@Entity
public class InvestOpp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oppId;
    @NotEmpty(message = "Please enter type")
    @Column(columnDefinition = "varchar(10) not null")
    private String oppType;
    @NotNull(message = "Please enter the cover amount")
    @Column(columnDefinition = "double not null")
    private Double coverAmount;
    @NotNull(message = "Please enter the limit of participants")
    @Column(columnDefinition = "int not null")
    private Integer limitPart;
    @NotNull(message = "Please enter the start date")
    @Column(columnDefinition = "date not null")
    private Date startDate;
    @NotNull(message = "Please enter the end date")
    @Column(columnDefinition = "date not null")
    private Date endDate;
    @NotEmpty(message = "Please enter the location")
    @Column(columnDefinition = "varchar(40) not null ")
    private String location;
    @Column(columnDefinition = "int not null")
    private Integer crCompany;

    public Integer getOppId() {
        return oppId;
    }

    public void setOppId(Integer oppId) {
        this.oppId = oppId;
    }

    public String getOppType() {
        return oppType;
    }

    public void setOppType(String oppType) {
        this.oppType = oppType;
    }

    public Double getCoverAmount() {
        return coverAmount;
    }

    public void setCoverAmount(Double coverAmount) {
        this.coverAmount = coverAmount;
    }



    public Integer getLimitPart() {
        return limitPart;
    }

    public void setLimitPart(Integer limitPart) {
        this.limitPart = limitPart;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCrCompany() {
        return crCompany;
    }

    public void setCrCompany(Integer crCompany) {
        this.crCompany = crCompany;
    }
}
