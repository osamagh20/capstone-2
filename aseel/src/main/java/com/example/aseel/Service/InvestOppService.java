package com.example.aseel.Service;

import com.example.aseel.ApiResponse.ApiException;
import com.example.aseel.Model.InvestOpp;
import com.example.aseel.Repository.InvestOppRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvestOppService {
    private final InvestOppRepository investOppRepository;
    public InvestOppService(InvestOppRepository investOppRepository) {
        this.investOppRepository = investOppRepository;
    }

    public List<InvestOpp> getAllInvestOpp(){
        return investOppRepository.findAll();
    }

    public List<InvestOpp> getInvestorsByLocation(String location) {
        List<InvestOpp> investOpps = investOppRepository.findInvestOppByLocation(location);
       if(investOpps == null){
           throw new ApiException("Investor not found");
       }
       return investOpps;
    }



//    public void updateInvestOpp(Integer id, InvestOpp investOpp){
//        InvestOpp oldInvestOpp = investOppRepository.findInvestOppByOppId(id);
//        if(oldInvestOpp == null){
//            throw new ApiException("id not found");
//        }
//        oldInvestOpp.setOppType(investOpp.getOppType());
//        oldInvestOpp.setCoverAmount(investOpp.getCoverAmount());
//        oldInvestOpp.setLimitPart(investOpp.getLimitPart());
//        oldInvestOpp.setStartDate(investOpp.getStartDate());
//        oldInvestOpp.setEndDate(investOpp.getEndDate());
//        oldInvestOpp.setLocation(investOpp.getLocation());
//        oldInvestOpp.setCrCompany(investOpp.getCrCompany());
//        investOppRepository.save(oldInvestOpp);
//    }


}
