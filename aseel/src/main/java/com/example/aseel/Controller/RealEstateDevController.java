package com.example.aseel.Controller;

import com.example.aseel.ApiResponse.ApiResponse;
import com.example.aseel.Model.ContractOpp;
import com.example.aseel.Model.InvestOpp;
import com.example.aseel.Model.RealEstateDev;
import com.example.aseel.Repository.RealEstateDevRepository;
import com.example.aseel.Service.RealEstateDevService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
 import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/real-estate-dev")
public class RealEstateDevController {

    private final RealEstateDevService realEstateDevService;
    private final RealEstateDevRepository realEstateDevRepository;

    public RealEstateDevController(RealEstateDevService realEstateDevService, RealEstateDevRepository realEstateDevRepository) {
        this.realEstateDevService = realEstateDevService;
        this.realEstateDevRepository = realEstateDevRepository;
    }

    @GetMapping("/get")
    public ResponseEntity getAllRealEstateDev() {
       List<RealEstateDev> realEstateDevList = realEstateDevService.getAllRealEstateDev();
       return ResponseEntity.status(200).body(realEstateDevList);
    }

    @PostMapping("/add")
    public ResponseEntity addRealEstateDev(@RequestBody @Valid RealEstateDev realEstateDev, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        realEstateDevService.addRealEsDev(realEstateDev);
        return ResponseEntity.status(200).body(new ApiResponse("Real Estate development added success"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRealEstateDev(@PathVariable Integer id, @RequestBody @Valid RealEstateDev realEstateDev,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        realEstateDevService.updateRealEstateDev(id, realEstateDev);
        return ResponseEntity.status(200).body(new ApiResponse("Real Estate dev updated success"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRealEstateDev(@PathVariable Integer id) {
        realEstateDevService.deleteRealEstateDev(id);
        return ResponseEntity.status(200).body(new ApiResponse("Real Estate dev deleted success"));
    }

    @PostMapping("/add-invest-opp")
    public ResponseEntity addInvestOpp(@RequestBody @Valid InvestOpp investOpp, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        realEstateDevService.addInvestOpp(investOpp);
        return ResponseEntity.status(200).body(new ApiResponse("investment opportunity added success"));
    }

    @DeleteMapping("/delete-invest-opp/{id}")
    public ResponseEntity deleteInvestOpp(@PathVariable Integer id) {
        realEstateDevService.deleteInvestOpp(id);
        return ResponseEntity.status(200).body(new ApiResponse("investment opportunity deleted success"));
    }

    @PutMapping("/accept-request/{id}")
    public ResponseEntity acceptRequest(@PathVariable Integer id) {
        realEstateDevService.acceptRequest(id);
        return ResponseEntity.status(200).body(new ApiResponse("Request accepted"));
    }

    @PutMapping("/reject-request/{id}")
    public ResponseEntity rejectRequest(@PathVariable Integer id) {
        realEstateDevService.rejectRequest(id);
        return ResponseEntity.status(200).body(new ApiResponse("Request rejected"));
    }

    @PostMapping("/make-contract/{id}")
    public ResponseEntity makeContract(@PathVariable Integer id,@RequestBody @Valid ContractOpp contract, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        realEstateDevService.makeContract(id,contract);
        return ResponseEntity.status(200).body(new ApiResponse("Contract accepted"));
    }

}