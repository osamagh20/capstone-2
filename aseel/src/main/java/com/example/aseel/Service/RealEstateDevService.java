package com.example.aseel.Service;

import com.example.aseel.ApiResponse.ApiException;
import com.example.aseel.Model.*;
import com.example.aseel.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateDevService {
    private final RealEstateDevRepository realEstateDevRepository;
    private final InvestOppRepository investOppRepository;
    private final RequestOppRepository requestOppRepository;
    private final ContractOppRepository contractOppRepository;

    public RealEstateDevService(RealEstateDevRepository realEstateDevRepository,InvestOppRepository investOppRepository,RequestOppRepository requestOppRepository, ContractOppRepository contractOppRepository) {
        this.realEstateDevRepository = realEstateDevRepository;
        this.investOppRepository = investOppRepository;
        this.requestOppRepository = requestOppRepository;
        this.contractOppRepository = contractOppRepository;
    }

    public List<RealEstateDev> getAllRealEstateDev() {
        return realEstateDevRepository.findAll();
    }


    public void addRealEsDev(RealEstateDev realEstateDev) {
        realEstateDevRepository.save(realEstateDev);
    }

    public void updateRealEstateDev(Integer id, RealEstateDev realEstateDev) {
        RealEstateDev updateRealEstateDev = realEstateDevRepository.findRealEstateDevByCR(id);
        if (updateRealEstateDev == null) {
            throw new ApiException("id not found");
        }
        updateRealEstateDev.setCompanyName(realEstateDev.getCompanyName());
        updateRealEstateDev.setCompanyEmail(realEstateDev.getCompanyEmail());
        updateRealEstateDev.setCompanyPhone(realEstateDev.getCompanyPhone());
        realEstateDevRepository.save(updateRealEstateDev);
    }

    public void deleteRealEstateDev(Integer id) {
        RealEstateDev delRealEstateDev = realEstateDevRepository.findRealEstateDevByCR(id);
        if (delRealEstateDev == null) {
            throw new ApiException("id not found");
        }
        realEstateDevRepository.delete(delRealEstateDev);
    }


    public void addInvestOpp(InvestOpp investOpp) {
        RealEstateDev find = realEstateDevRepository.findRealEstateDevByCR(investOpp.getCrCompany());
        System.out.println(find);
        if (find == null) {
            return;
        }
        investOppRepository.save(investOpp);
    }


    public void deleteInvestOpp(Integer id){
        InvestOpp delInvestOpp = investOppRepository.findInvestOppByOppId(id);
        if(delInvestOpp == null){
            throw new ApiException("id not found");
        }
        investOppRepository.delete(delInvestOpp);
        RequestOpp delReq =  requestOppRepository.findRequestOppById(delInvestOpp.getOppId());
        if(delReq == null){
            throw new ApiException("id not found");
        }
        requestOppRepository.delete(delReq);
    }


    public void acceptRequest(Integer id) {
            RequestOpp requestOpp = requestOppRepository.findRequestOppById(id);
            if(requestOpp != null && requestOpp.getStatus().equals("pending")){
                requestOpp.setStatus("accepted");
            }

            throw new ApiException("request not found");
    }


    public void rejectRequest(Integer id) {
        RequestOpp requestOpp = requestOppRepository.findRequestOppById(id);
        if(requestOpp != null && requestOpp.getStatus().equals("pending")){
                requestOpp.setStatus("rejected");
        }
        throw new ApiException("request not found");
    }


    public void makeContract(Integer reqId,ContractOpp contractOpp) {
        if(requestOppRepository.findRequestOppById(reqId) != null){
            if(requestOppRepository.findRequestOppById(reqId).getStatus().equals("accepted")){
                contractOppRepository.save(contractOpp);
                contractOpp.setCount_invest(contractOpp.getCount_invest() + 1);
            }
        }
    }
}