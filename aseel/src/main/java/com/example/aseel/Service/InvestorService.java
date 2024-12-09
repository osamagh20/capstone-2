package com.example.aseel.Service;

import com.example.aseel.ApiResponse.ApiException;
import com.example.aseel.Model.Investor;
import com.example.aseel.Model.RequestOpp;
import com.example.aseel.Repository.InvestOppRepository;
import com.example.aseel.Repository.InvestorRepository;
import com.example.aseel.Repository.RequestOppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestorService {
    private final InvestorRepository investorRepository;
    private final RequestOppRepository requestOppRepository;
    private final InvestOppRepository investOppRepository;

    public InvestorService(InvestorRepository investorRepository, RequestOppRepository requestOppRepository, InvestOppRepository investOppRepository) {
        this.investorRepository = investorRepository;
        this.requestOppRepository = requestOppRepository;
        this.investOppRepository = investOppRepository;
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public void addInvestor(Investor investor) {
        investorRepository.save(investor);
    }

    public void updateInvestor(Integer id,Investor investor) {
        Investor oldInvestor = investorRepository.findInvestorById(id);
        if(oldInvestor == null) {
            throw new ApiException("id not found");
        }
        oldInvestor.setUsername(investor.getUsername());
        oldInvestor.setEmail(investor.getEmail());
        oldInvestor.setPassword(investor.getPassword());
        investorRepository.save(oldInvestor);
    }

    public void deleteInvestor(Integer id) {
        Investor delInvestor = investorRepository.findInvestorById(id);
        if(delInvestor == null) {
            throw new ApiException("id not found");
        }
        investorRepository.delete(delInvestor);
    }


    public void applyRequest(RequestOpp request) {
        if(investorRepository.findInvestorById(request.getInvestId()) != null) {
            if(investOppRepository.findInvestOppByOppId(request.getIdOpp()) != null) {
                request.setStatus("pending");
                requestOppRepository.save(request);
            }

        }
    }



}