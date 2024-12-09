package com.example.aseel.Repository;

import com.example.aseel.Model.ContractOpp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractOppRepository extends JpaRepository<ContractOpp, Integer> {

    ContractOpp findContractOppByContractId(Integer contractId);

    @Query("select c from ContractOpp c where c.idOpp=?1 And c.count_invest>=?2")
    List<ContractOpp> getInvestorsByInvestingTimes(Integer idOpp,Integer investingTimes);
}
