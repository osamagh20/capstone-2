package com.example.aseel.Repository;

import com.example.aseel.Model.InvestOpp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestOppRepository extends JpaRepository<InvestOpp, Integer> {

    InvestOpp findInvestOppByOppId(Integer investOppId);

    List<InvestOpp> findInvestOppByLocation(String location);
}
