package com.example.aseel.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class RequestOpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Please enter your description")
    @Column(columnDefinition = "varchar(200) not null")
    private String description;
    @Column(columnDefinition = "varchar(10) ")
    private String status;
    @NotNull(message = "Enter your amount")
    @Column(columnDefinition = "int not null")
    private Integer investAmount;
    @NotNull(message = "Please enter investor id")
    @Column(columnDefinition = "int not null")
    private Integer investId;
    @NotNull(message = "Please enter opportunity id ")
    @Column(columnDefinition = "int not null")
    private Integer idOpp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInvestId() {
        return investId;
    }

    public void setInvestId(Integer investId) {
        this.investId = investId;
    }

    public Integer getIdOpp() {
        return idOpp;
    }

    public void setIdOpp(Integer idOpp) {
        this.idOpp = idOpp;
    }

    public Integer getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(Integer investAmount) {
        this.investAmount = investAmount;
    }
}
