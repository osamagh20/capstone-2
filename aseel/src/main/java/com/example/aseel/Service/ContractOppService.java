package com.example.aseel.Service;

import com.example.aseel.Model.ContractOpp;
import com.example.aseel.Model.InvestOpp;
import com.example.aseel.Model.Investor;
import com.example.aseel.Repository.ContractOppRepository;
import com.example.aseel.Repository.InvestOppRepository;
import com.example.aseel.Repository.InvestorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class ContractOppService {
    private final ContractOppRepository contractOppRepository;
    private final InvestorRepository investorRepository;
    private final InvestOppRepository investOppRepository;

    public ContractOppService(ContractOppRepository contractOppRepository, InvestorRepository investorRepository, InvestOppRepository investOppRepository) {
        this.contractOppRepository = contractOppRepository;
        this.investorRepository = investorRepository;
        this.investOppRepository = investOppRepository;
    }

    public List<ContractOpp> getAllContractOpp() {
        return contractOppRepository.findAll();
    }

    public List<ContractOpp> getInvestorsByInvestCounter(Integer idOpp, Integer investCounter) {
        List<ContractOpp> contractOppList = contractOppRepository.getInvestorsByInvestingTimes(idOpp, investCounter);
        if (contractOppList.isEmpty()) {
            return null;
        }
        return contractOppList;
    }


}
