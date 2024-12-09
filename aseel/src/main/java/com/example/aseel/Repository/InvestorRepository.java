package com.example.aseel.Repository;

import com.example.aseel.Model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {

    Investor findInvestorById(Integer id);


}
