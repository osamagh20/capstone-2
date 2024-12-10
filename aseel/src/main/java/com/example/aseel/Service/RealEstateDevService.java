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
    private final InvestorRepository investorRepository;

    public RealEstateDevService(RealEstateDevRepository realEstateDevRepository, InvestOppRepository investOppRepository, RequestOppRepository requestOppRepository, ContractOppRepository contractOppRepository, InvestorRepository investorRepository) {
        this.realEstateDevRepository = realEstateDevRepository;
        this.investOppRepository = investOppRepository;
        this.requestOppRepository = requestOppRepository;
        this.contractOppRepository = contractOppRepository;
        this.investorRepository = investorRepository;
    }

    public List<RealEstateDev> getAllRealEstateDev() {
        return realEstateDevRepository.findAll();
    }


    public void addRealEsDev(RealEstateDev realEstateDev) {
        realEstateDevRepository.save(realEstateDev);
    }

    public void updateRealEstateDev(Integer id, RealEstateDev realEstateDev) {
        RealEstateDev updateRealEstateDev = realEstateDevRepository.findRealEstateDevById(id);
        if (updateRealEstateDev == null) {
            throw new ApiException("id not found");
        }
        updateRealEstateDev.setCompanyName(realEstateDev.getCompanyName());
        updateRealEstateDev.setCompanyEmail(realEstateDev.getCompanyEmail());
        updateRealEstateDev.setPhoneNumber(realEstateDev.getPhoneNumber());
        updateRealEstateDev.setAssets(realEstateDev.getAssets());
        updateRealEstateDev.setCommercialRecord(realEstateDev.getCommercialRecord());
        realEstateDevRepository.save(updateRealEstateDev);
    }

    public void deleteRealEstateDev(Integer id) {
        RealEstateDev delRealEstateDev = realEstateDevRepository.findRealEstateDevById(id);
        if (delRealEstateDev == null) {
            throw new ApiException("id not found");
        }
        realEstateDevRepository.delete(delRealEstateDev);
    }


    public void addInvestOpp(InvestOpp investOpp) {
        RealEstateDev find = realEstateDevRepository.findRealEstateDevById(investOpp.getCrCompany());
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
            InvestOpp investOpp = investOppRepository.findInvestOppByOppId(id);
            if(requestOpp != null && requestOpp.getStatus().equals("pending")){
                requestOpp.setStatus("accepted");
                investOpp.setCoverAmount(investOpp.getCoverAmount() - requestOpp.getInvestAmount());
                for (int i = 0; i < requestOppRepository.findAll().size(); i++) {
                    if(requestOppRepository.findAll().get(i).getStatus().equals("pending")){
                        requestOppRepository.delete(requestOppRepository.findAll().get(i));
                    }
                }
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