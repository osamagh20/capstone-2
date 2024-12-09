package com.example.aseel.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class RequestOpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Please enter your description")
    @Column(columnDefinition = "varchar(200) not null")
    private String des;
    @Column(columnDefinition = "varchar(10) ")
    private String status;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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
}
