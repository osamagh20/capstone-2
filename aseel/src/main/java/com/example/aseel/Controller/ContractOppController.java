package com.example.aseel.Controller;

import com.example.aseel.Model.ContractOpp;
import com.example.aseel.Service.ContractOppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contract-opp")
public class ContractOppController {
    private final ContractOppService contractOppService;
    public ContractOppController(ContractOppService contractOppService) {
        this.contractOppService = contractOppService;
    }
    @GetMapping("/get")
    public ResponseEntity getAllContractOpp() {
        List<ContractOpp> contractOpps = contractOppService.getAllContractOpp();
        return ResponseEntity.status(200).body(contractOpps);
    }

    @GetMapping("/get-by-invest-count/{idOpp}/{investCounter}")
    public ResponseEntity getInvestorsByInvestCounter(@PathVariable Integer idOpp,@PathVariable Integer investCounter) {
        List<ContractOpp> contractOppList = contractOppService.getInvestorsByInvestCounter(idOpp,investCounter);
        return ResponseEntity.status(200).body(contractOppList);
    }

}
