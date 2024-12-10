package com.example.aseel.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;



@Entity
public class ContractOpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    @NotNull(message = "Please enter investor id")
    @Column(columnDefinition = "int not null")
    private Integer investorId;
    @NotNull(message = "Please enter opportunity id")
    @Column(columnDefinition = "int not null")
    private Integer idOpp;
    @Column(columnDefinition = "int")
    private Integer count_invest;


    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Integer investorId) {
        this.investorId = investorId;
    }

    public Integer getIdOpp() {
        return idOpp;
    }

    public void setIdOpp(Integer idOpp) {
        this.idOpp = idOpp;
    }

    public Integer getCount_invest() {
        return count_invest;
    }

    public void setCount_invest(Integer count_invest) {
        this.count_invest = count_invest;
    }


}
