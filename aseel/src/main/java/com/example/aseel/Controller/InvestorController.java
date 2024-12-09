package com.example.aseel.Controller;

import com.example.aseel.ApiResponse.ApiResponse;
import com.example.aseel.Model.Investor;
import com.example.aseel.Model.RequestOpp;
import com.example.aseel.Service.InvestorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investor")
public class InvestorController {
    private final InvestorService investorService;

    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllInvestors(){
        List<Investor> investors = investorService.getAllInvestors();
        return ResponseEntity.status(200).body(investors);
    }

    @PostMapping("/add")
    public ResponseEntity addInvestor(@RequestBody @Valid Investor investor, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        investorService.addInvestor(investor);
        return ResponseEntity.status(200).body(new ApiResponse("Investor added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateInvestor(@PathVariable Integer id, @RequestBody @Valid Investor investor,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        investorService.updateInvestor(id, investor);
        return ResponseEntity.status(200).body(new ApiResponse("Investor updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteInvestor(@PathVariable Integer id){
        investorService.deleteInvestor(id);
        return ResponseEntity.status(200).body(new ApiResponse("Investor deleted successfully"));
    }

    @PostMapping("/apply-request")
    public ResponseEntity applyRequest(@RequestBody @Valid RequestOpp requestOpp, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        investorService.applyRequest(requestOpp);
        return ResponseEntity.status(200).body(new ApiResponse("Investor apply successfully"));
    }


}
