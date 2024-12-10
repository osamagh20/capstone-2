package com.example.aseel.Service;

import com.example.aseel.Model.RequestOpp;
import com.example.aseel.Repository.RequestOppRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestOppService {
    private final RequestOppRepository requestOppRepository;
    public RequestOppService(RequestOppRepository requestOppRepository) {
        this.requestOppRepository = requestOppRepository;
    }

    public List<RequestOpp> getAllRequestOpp() {
        return requestOppRepository.findAll();
    }

    public RequestOpp getRequestOppById(Integer id) {
        return requestOppRepository.findRequestOppById(id);
    }
}
