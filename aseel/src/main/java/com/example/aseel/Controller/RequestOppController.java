package com.example.aseel.Controller;

import com.example.aseel.Model.RequestOpp;
import com.example.aseel.Service.RequestOppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/request-opp")
public class RequestOppController {
    private final RequestOppService requestOppService;
    public RequestOppController(RequestOppService requestOppService) {
        this.requestOppService = requestOppService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllRequestOpps() {
        List<RequestOpp> requestOppList = requestOppService.getAllRequestOpp();
        return ResponseEntity.status(200).body(requestOppList);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity getRequestOppById(@PathVariable Integer id){
        RequestOpp requestOpp = requestOppService.getRequestOppById(id);
        return ResponseEntity.status(200).body(requestOpp);
    }
}
