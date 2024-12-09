package com.example.aseel.Controller;

import com.example.aseel.Model.InvestOpp;
import com.example.aseel.Service.InvestOppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invest-opp")
public class InvestOppController {
    private final InvestOppService investOppService;


    public InvestOppController(InvestOppService investOppService) {
        this.investOppService = investOppService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllInvestOpp() {
        List<InvestOpp> investOpps = investOppService.getAllInvestOpp();
        return ResponseEntity.status(200).body(investOpps);
    }

    @GetMapping("/get-by-location/{location}")
    public ResponseEntity getAllInvestOppByLocation(@PathVariable String location) {
        List<InvestOpp> investOpps = investOppService.getInvestorsByLocation(location);
        return ResponseEntity.status(200).body(investOpps);
    }

}
